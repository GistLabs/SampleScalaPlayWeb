/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import controllers.SecuredActions
import org.specs2.mutable._
import play.api.http.HeaderNames
import play.api.libs.json.{JsString, Json}
import play.api.mvc.Cookie
import play.api.test._
import play.api.test.Helpers._
import xml.XML


class ControllersSpec extends Specification {
  "index action" in {
    val result = controllers.Application.index()(FakeRequest())
    status(result) must equalTo(OK)
    contentType(result) must beSome("text/html")
    charset(result) must beSome("utf-8")
  }

  "infinite redirect action" in {
    val result = controllers.ResponseCodesController.infiniteRedir()(FakeRequest())
    status(result) must beBetween(300, 399)
  }

  "Internal Server Error" in {
    val result = controllers.ResponseCodesController.internalServerError()(FakeRequest())
    status(result) must beBetween(500, 599)
  }

  "Test Tag Xml Echo" in {
    running(FakeApplication()) {
      val result = route(FakeRequest(POST, controllers.routes.SimpleResultsController.echoTestTagFromXml().url).
        withHeaders(CONTENT_TYPE -> "text/xml"), "<test>test</test>").get

      val data = XML.loadString(contentAsString(result))
      (data \\ "echo").text must equalTo("test")
      status(result) must equalTo(OK)
    }
  }

  "Hello form GistLabs!" in {
    val result = controllers.SimpleResultsController.xmlResult()(FakeRequest())
    val data = XML.loadString(contentAsString(result))
    (data \\ "message").text must contain("GistLabs")
  }


  "Echo Cookies" in {
    running(FakeApplication()) {
      val result = route(FakeRequest(GET, controllers.routes.SimpleResultsController.echoCookies().url).
        withCookies(new Cookie("test", "test")), "").get

      val cookies = header(SET_COOKIE, result).getOrElse("")

      status(result) must equalTo(OK)
      cookies must contain("test")
    }
  }

  "Get ETag / Cache-Control" in {
    running(FakeApplication()){
      val result = controllers.SimpleResultsController.cachedResult()(FakeRequest())
      headers(result).get(ETAG) mustNotEqual(None)
      headers(result).get(CACHE_CONTROL) mustNotEqual(None)
    }
  }

  "Send If-None-Match and get Not-Modified" in {
    running(FakeApplication()){
      val result = controllers.SimpleResultsController.cachedResult()(FakeRequest().withHeaders((IF_NONE_MATCH,"xx")))
      status(result) mustEqual NOT_MODIFIED
    }
  }

  val securedAreaRequest = FakeRequest(GET, controllers.routes.SecuredActions.securedArea().url)

  "Try to access secured area without credentials" in {
    running(FakeApplication()) {
      val result = route(securedAreaRequest).get
      status(result) must equalTo(UNAUTHORIZED)
    }
  }

  "Go to secured area with wrong credentials" in {
    running(FakeApplication()) {
      val result = route(securedAreaRequest.withSession("login" -> "istlabs")).get
      status(result) must equalTo(UNAUTHORIZED)
    }
  }

  "Go to secured area with right credentials" in {
    running(FakeApplication()) {
      val result = route(securedAreaRequest.withSession("login" -> "gistlabs")).get
      status(result) must equalTo(OK)
      contentAsString(result) must contain(SecuredActions.token)
    }
  }

  "JSON put with wrong headers" in {
    running(FakeApplication()) {
      val result = route(FakeRequest(PUT, controllers.routes.JsonController.putValue().url).
        withHeaders(CONTENT_TYPE -> "text/html"), "{\"status\":\"new\"}").get

      status(result) mustNotEqual (OK)
    }
  }

  val jsonTestValue = "new Value"
  val json = Json.obj(
    "value" -> JsString(jsonTestValue)
  )

  val putReq = FakeRequest(PUT, controllers.routes.JsonController.putValue().url).
    withHeaders(CONTENT_TYPE -> "application/json")

  "JSON put with right headers" in {
    running(FakeApplication()) {
      val result = route(putReq, json).get

      status(result) mustEqual (OK)
      contentAsString(result) must contain("status")
      contentAsString(result) must contain("OK")
    }
  }

  "JSON put then get" in {
    running(FakeApplication()) {
      route(putReq, json)

      val getReq = FakeRequest(GET, controllers.routes.JsonController.putValue().url).
        withHeaders(CONTENT_TYPE -> "application/json")

      val result = route(getReq).get

      contentAsString(result) must contain(jsonTestValue)
      status(result) mustEqual (OK)
    }
  }
}