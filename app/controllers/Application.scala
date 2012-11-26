/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package controllers

import models._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.Play
import java.io.File

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def redir = Action {
    Redirect(routes.Application.index)
  }

  def infiniteRedir = Action {
    Redirect(routes.Application.infiniteRedir)
  }

  def xmlResult = Action {
    Ok(<message>Hello form GistLabs!</message>)
  }

  def imgResult = Action {
    Ok(views.html.imgexample())
  }

  def strangeResponseCode = Action {
    Status(466)("466 Response code")
  }

  def echoCookies = Action { request =>
    val cookies = request.headers(COOKIE)
    Ok(views.html.echocookies(cookies)).withHeaders(SET_COOKIE -> cookies)
  }

  def internalServerError = Action {
    InternalServerError("Oops")
  }

  def customCookie = Action {
    Ok(views.html.index()).withCookies(Cookie("sender", "gistlabs"))
  }

  /**
   * Client Form definition.
   */
  val clientForm: Form[Client] = Form(

    // Defines a mapping that will handle Contact values
    mapping(
      "username" -> nonEmptyText,
      "firstname" -> nonEmptyText,
      "lastname" -> nonEmptyText)(Client.apply)(Client.unapply))

  def simpleForms = Action {
    Ok(views.html.simpleforms(clientForm))
  }

  def simpleFormsGetSubmit = Action { implicit request =>
    def param(field: String): Option[String] = request.queryString.get(field).flatMap(_.headOption)
    Ok(views.html.showSimpleFormsResult(Map("name" -> param("name").getOrElse(""))))
  }

  def simpleFormsPostSubmit = Action { implicit request =>
    val form = clientForm.bindFromRequest()
    form.fold(
      errors => BadRequest(views.html.simpleforms(form.copy(errors = form.errors))),
      client => Ok(views.html.showSimpleFormsResult(form.data)))
  }

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