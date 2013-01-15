/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package controllers

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

protected object AuthConstants {
  val TrueUsername = "gistlabs"
}

trait Secured {
  private def username(request: RequestHeader) = request.session.get("login")

  private def onUnauthorized(request: RequestHeader) = Results.Unauthorized

  def withAuth(f: => String => Request[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorized) {
      user =>
        if (user == AuthConstants.TrueUsername) {
          Action(request => f(user)(request))
        } else {
          Action(Results.Unauthorized)
        }
    }
  }
}

object Auth extends Controller {
  val loginForm = Form(
    tuple(
      "login" -> text,
      "password" -> text
    ) verifying("Wrong credentials provided", result => result match {
      case (login, password) => login == AuthConstants.TrueUsername && !password.isEmpty
    })
  )

  def login = Action {
    implicit request =>
      Ok(views.html.login(loginForm))
  }

  def authenticate = Action {
    implicit request =>
      loginForm.bindFromRequest.fold(
        formWithErrors => BadRequest(views.html.login(formWithErrors)),
        user => Redirect(routes.SecuredActions.securedArea()).withSession("login" -> user._1)
      )
  }
}


object SecuredActions extends Controller with Secured {
  val token = "gst397"

  def securedArea = withAuth {
    username => implicit request =>
      Ok(views.html.securedArea(username, token))
  }
}