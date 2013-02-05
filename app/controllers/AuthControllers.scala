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
import org.apache.commons.lang3.RandomStringUtils


object AuthConstants {
  val TrueUsername = "gistlabs"
  val username = Security.username + RandomStringUtils.randomAlphanumeric(5)
}

trait Secured {
  private def username(request: RequestHeader) = request.session.get(AuthConstants.username)

  private def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Auth.login())

  def withAuth(f: => String => Request[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorized) {
      user =>
        if (user == AuthConstants.TrueUsername) {
          Action(request => f(user)(request))
        } else {
          Action(Results.Forbidden)
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

  def logout = Action {
    Redirect(routes.Auth.login).withNewSession.flashing(
      "success" -> "You've been logged out"
    )
  }

  def authenticate = Action {
    implicit request =>
      loginForm.bindFromRequest.fold(
        formWithErrors => BadRequest(views.html.login(formWithErrors)),
        user => Redirect(routes.SecuredActions.securedArea()).withSession(AuthConstants.username -> user._1)
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