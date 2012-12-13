/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package controllers

import play.api.mvc.{Action, Controller}
import play.api.data.Form
import play.api.data.Forms._
import models.Client
import play.api.Play
import java.io.File


object FormsController extends Controller {
  val simpleForm: Form[Client] = Form(

    // Defines a mapping that will handle Contact values
    mapping(
      "username" -> nonEmptyText,
      "firstname" -> nonEmptyText,
      "lastname" -> nonEmptyText)(Client.apply)(Client.unapply))

  def simpleForms = Action {
    Ok(views.html.simpleforms(simpleForm))
  }

  def simpleFormsGetSubmit = Action { implicit request =>
    def param(field: String): Option[String] = request.queryString.get(field).flatMap(_.headOption)
    Ok(views.html.showSimpleFormsResult(Map("name" -> param("name").getOrElse(""))))
  }

  def simpleFormsPostSubmit = Action { implicit request =>
    val form = simpleForm.bindFromRequest()
    form.fold(
      errors => BadRequest(views.html.simpleforms(form.copy(errors = form.errors))),
      client => Ok(views.html.showSimpleFormsResult(form.data)))
  }
}


object FilesController extends Controller{
  def showUpload = Action {
    Ok(views.html.showUpload())
  }

  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("file").map { file =>
      val filename = file.filename
      val fullFilename = Play.current.configuration.getString("tmp.path") + "/" + filename
      file.ref.moveTo(new File(fullFilename))
      Ok(views.html.showUploadedDownload(filename))
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file")
    }
  }

  def download(filename: String) = Action {
    val fullFilename = Play.current.configuration.getString("tmp.path") + "/" + filename
    Ok.sendFile(new java.io.File(fullFilename))
  }
}
