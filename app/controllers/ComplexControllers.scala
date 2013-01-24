/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package controllers

import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.Play
import play.api.libs.Files
import play.api.libs.json._

import java.io.File
import java.util.Date
import scala.Some
import models.User
import models.Client
import play.api.cache.Cache
import org.apache.commons.lang3.RandomStringUtils


object FormsController extends Controller {
  val simpleForm: Form[Client] = Form(
    mapping(
      "username" -> nonEmptyText,
      "firstname" -> nonEmptyText,
      "lastname" -> nonEmptyText)(Client.apply)(Client.unapply)
  )

  val userForm: Form[User] = Form(
    // Define a mapping that will handle User values
    mapping(
      "login" -> text(minLength = 4),
      "email" -> email,
      "password" -> tuple(
        "pass1" -> text(minLength = 6),
        "pass2" -> text
      ).verifying(
        "Passwords don't match", passwords => passwords._1 == passwords._2
      ),
      "reference" -> text,
      "newsletter" -> text,
      "tos" -> checked("You must accept the conditions"),
      "hiddenDate" -> date("MM-dd-yyyy")
    ) {
      // Binding
      (username, email, passwords, reference, newsletter, hiddenDate, _) => User(username, passwords._1, reference, newsletter, email)
    } {
      // Unbinding
      user => Some(user.login, user.email, (user.password, ""), user.reference, user.newsletter, false, new Date())
    }.verifying(
      "This username is not available",
      user => !Seq("admin", "guest").contains(user.login)
    )
  )

  def simpleForms = Action {
    Ok(views.html.simpleforms(simpleForm))
  }

  def advancedForm = Action {
    Ok(views.html.advancedForm(userForm))
  }

  def userFormSubmit = Action {
    implicit request =>
      val form = userForm.bindFromRequest()
      play.Logger.info(form.errors.mkString("  "))
      form.fold(
        errors => BadRequest(views.html.advancedForm(form.copy(errors = form.errors))),
        user => Ok(views.html.echoUserForm(form.data))
      )
  }

  def simpleFormsGetSubmit = Action {
    implicit request =>
      def param(field: String): Option[String] = request.queryString.get(field).flatMap(_.headOption)
      Ok(views.html.showSimpleFormsResult(Map("name" -> param("name").getOrElse(""))))
  }

  def simpleFormsPostSubmit = Action {
    implicit request =>
      val form = simpleForm.bindFromRequest()
      form.fold(
        errors => BadRequest(views.html.simpleforms(form.copy(errors = form.errors))),
        client => Ok(views.html.showSimpleFormsResult(form.data)))
  }
}


object FilesController extends Controller {
  def tmpFolder = Play.current.configuration.getString("tmp.path").getOrElse("/tmp")

  val filesFolder = "/files"

  def index = Action {
    Ok(views.html.filesHelp())
  }

  def filesEndpointPost = Action(parse.temporaryFile) {
    request =>
      request.headers.get(CONTENT_TYPE) match {
        case Some(cType) =>
          val fileExtension = cType.substring(cType.lastIndexOf("/") + 1, cType.length)
          val filename = RandomStringUtils.randomAlphanumeric(5) + "." + fileExtension
          val visibleFilename = filesFolder + "/" + filename
          val fullFilename = tmpFolder + "/" + filename

          request.body.moveTo(new File(fullFilename), true)
          Created.withHeaders(LOCATION -> visibleFilename)
        case None =>
          BadRequest("No content type given")
      }
  }

  def filesEndpointPut(shortFilename: String) = Action(parse.temporaryFile) {
    request =>
      val fullFilename = tmpFolder + "/" + shortFilename
      request.body.moveTo(new File(fullFilename), true)
      Ok("file created").withHeaders(LOCATION -> (filesFolder + "/" + shortFilename))
  }


  def filesEndpointGet(shortFilename: String) = Action {
    Ok.sendFile(new java.io.File("/tmp/"+shortFilename))
  }



  def showSingleUpload = showUpload(false)

  def showMultiUpload = showUpload(true)

  def showUpload(multi: Boolean) = Action {
    Ok(views.html.showUpload(multi))
  }


  def upload = Action {
    request =>
      def writeFile(file: MultipartFormData.FilePart[Files.TemporaryFile]): String = {
        val filename = file.filename
        val fullFilename = tmpFolder + "/" + filename
        file.ref.moveTo(new File(fullFilename), true)
        filename
      }

      val filenames = request.body.asMultipartFormData.headOption.map {
        multi =>
          for (file <- multi.files) yield writeFile(file)
      }

      filenames match {
        case Some(names) => Ok(views.html.showUploadedDownload(names))
        case None => BadRequest("Missing file")
      }
  }

  def download(filename: String) = Action {
    val fullFilename = tmpFolder + "/" + filename
    Ok.sendFile(new java.io.File(fullFilename))
  }
}


object JsonController extends Controller {

  import play.api.Play.current

  def index = Action {
    Ok(views.html.jsonHelp())
  }

  def getValue = Action {
    val value = Cache.getAs[String]("jsonTest").getOrElse("")
    Ok(Json.toJson(
      Map("echo" -> value)
    ))
  }

  def putValue = Action(parse.json) {
    request =>
      (request.body \ "jsonTest").asOpt[String].map {
        value =>
          Cache.set("jsonTest", value)

          Ok(Json.toJson(
            Map("status" -> "OK")
          ))

      }.getOrElse {
        BadRequest(Json.toJson(
          Map("status" -> "error", "details" -> "jsonTest parameter missed")
        ))
      }
  }
}


object XmlController extends Controller {

  import play.api.Play.current

  def index = Action {
    Ok(views.html.xmlHelp())
  }

  def getValue = Action {
    val value = Cache.getAs[String]("xmlTest").getOrElse("")
    Ok(views.xml.xmlTest(value))
  }


  val xmlTestTag = "xmlTest"

  def putValue = Action {
    request =>
      request.body.asXml.map {
        xml =>
          (xml \\ xmlTestTag headOption).map(_.text).map {
            value =>
              Cache.set("xmlTest", value)

              Ok(<status>Ok</status>)
          }.getOrElse {
            BadRequest(<status>error</status> <details>Missing parameter [xmlTestTag]</details>)
          }
      }.getOrElse {
        BadRequest(<status>error</status> <details>Expecting Xml data</details>)
      }
  }


}