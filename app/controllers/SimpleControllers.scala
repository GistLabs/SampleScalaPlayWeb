/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package controllers

import play.api.mvc._
import play.api.mvc.Cookie
import play.api.cache.Cached


object IndexController extends Controller {
  def index = Action {
    Ok(views.html.index())
  }
}

object ResponseCodesController extends Controller {
  def redir = Action {
    Redirect(routes.ResponseCodesController.redirTarget())
  }

  def redirTarget = Action {
    Ok(views.html.redirectTarget())
  }

  def infiniteRedir = Action {
    Redirect(routes.ResponseCodesController.infiniteRedir)
  }

  def strangeResponseCode = Action {
    Status(466)("466 Response code")
  }

  def internalServerError = Action {
    InternalServerError("Oops")
  }
}


object SimpleResultsController extends Controller {
  def xmlResult = Action {
    Ok(<message>Hello form GistLabs!</message>)
  }

  def echoCookies = Action {
    implicit request =>
      val cookies = request.headers.get(COOKIE).getOrElse("")
      Ok(views.html.echocookies(cookies)).withHeaders(SET_COOKIE -> cookies)
  }

  def customCookie = Action {
    Ok(views.html.customCookieTarget()).withCookies(Cookie("sender", "gistlabs"))
  }

  def imgResult = Action {
    Ok(views.html.imgexample())
  }

  def cachedResult = Action {request =>
    request.headers.get(IF_NONE_MATCH) match {
      case Some(x) => NotModified
      case None => Ok(views.html.cachedPage()).withHeaders((CACHE_CONTROL, "max-age=3600"),(ETAG, "xxx"))
    }
  }
}