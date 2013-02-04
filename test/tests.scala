/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import collection.parallel.mutable
import controllers.{FilesController, SimpleResultsController, SecuredActions}
import java.io.File
import org.specs2.execute
import org.specs2.mutable._
import play.api.http.{Writeable, DefaultWriteables, HeaderNames}
import play.api.libs.json.JsString
import play.api.libs.json.JsString
import play.api.libs.json.{JsString, Json}
import play.api.Logger
import play.api.mvc._
import play.api.mvc.Cookie
import play.api.templates.Xml
import play.api.test._
import play.api.test.FakeHeaders
import play.api.test.Helpers._
import play.api.test.WithApplication
import xml.XML
import org.specs2.execute.{AsResult, StandardResults}
import play.api.mvc._
import play.api.mvc.Results
import play.api.test._
import play.api.test.Helpers._


class ControllersSpec extends Specification {
  override def is = args(sequential = true, isolated = true) ^ super.is

  "Sample Scala Play Web Application" should {
    "Show index action" in {
      val result = controllers.Application.index()(FakeRequest())
      status(result) must equalTo(OK)
      contentType(result) must beSome("text/html")
      charset(result) must beSome("utf-8")
    }

    "Make Infinite Redirect" in {
      val result = controllers.ResponseCodesController.infiniteRedir()(FakeRequest())
      status(result) must beBetween(300, 399)
    }

    "Show Internal Server Error" in {
      val result = controllers.ResponseCodesController.internalServerError()(FakeRequest())
      status(result) must beBetween(500, 599)
    }

    "Get 'Hello from GistLabs!' simple xml message" in {
      val result = controllers.SimpleResultsController.xmlResult()(FakeRequest())
      val data = XML.loadString(contentAsString(result))
      (data \\ "message").text must contain("GistLabs")
    }

    "Echo Cookies" in new WithApplication {
      val result = route(FakeRequest(GET, controllers.routes.SimpleResultsController.echoCookies().url).
        withCookies(new Cookie("test", "test")), "").get

      val cookies = header(SET_COOKIE, result).getOrElse("")
      status(result) must equalTo(OK)
      cookies must contain("test")
    }

    lazy val filesPostRoute = route(FakeRequest(POST,
      controllers.routes.FilesController.filesEndpointPost().url,
      FakeHeaders(Seq(CONTENT_TYPE -> Seq("application/pdf"))),
      "brokenpdf"))(new Writeable({
      s: String => s.getBytes
    }, None))

    "Send binary stream with POST to /files" in new WithApplication {
      val result = filesPostRoute.get
      status(result) mustEqual CREATED
      header(LOCATION, result).getOrElse("") must contain("files/")
      header(LOCATION, result).getOrElse("") must contain(".pdf")

    }

    "Send binary stream with POST to /files then GET it" in new WithApplication {
      val postResult = filesPostRoute.get
      val result = route(FakeRequest(GET, header(LOCATION, postResult).getOrElse("invalidUrl"))).get
      status(result) mustEqual OK
      contentAsString(result) mustEqual "brokenpdf"
    }

    "Send binary stream with existing name to /files with PUT" in new WithApplication {
      val putRoute = route(FakeRequest(PUT,
        controllers.routes.FilesController.filesEndpointPut("broken2.pdf").url,
        FakeHeaders(Seq(CONTENT_TYPE -> Seq("application/pdf"))),
        "brokenpdf"))(new Writeable({
        s: String => s.getBytes
      }, None))

      val result = putRoute.get
      status(result) mustEqual OK

      val result2 = route(FakeRequest(PUT,
        controllers.routes.FilesController.filesEndpointPut("broken2.pdf").url,
        FakeHeaders(Seq(CONTENT_TYPE -> Seq("application/pdf"))),
        "brokenpdf"))(new Writeable({
        s: String => s.getBytes
      }, None)).get

      status(result2) mustEqual CONFLICT
    }


    "Send binary stream with PUT to /files then GET it" in new WithApplication {
      val putRoute = route(FakeRequest(PUT,
        controllers.routes.FilesController.filesEndpointPut("broken1.pdf").url,
        FakeHeaders(Seq(CONTENT_TYPE -> Seq("application/pdf"))),
        "brokenpdf"))(new Writeable({
        s: String => s.getBytes
      }, None))

      val putResult = putRoute.get
      status(putResult) mustEqual OK
      header(LOCATION, putResult).getOrElse("") must contain("files/")
      header(LOCATION, putResult).getOrElse("") must contain("broken1.pdf")
      Thread.sleep(1000)

      val result = route(FakeRequest(GET, controllers.routes.FilesController.filesEndpointGet("broken1.pdf").url)).get
      status(result) mustEqual OK
      contentAsString(result) mustEqual "brokenpdf"
    }


    "Get ETag / Cache-Control" in new WithApplication {
      val result = controllers.SimpleResultsController.cachedResult()(FakeRequest())
      headers(result).get(ETAG) mustNotEqual (None)
      headers(result).get(CACHE_CONTROL) mustNotEqual (None)
    }

    "Send If-None-Match and get Not-Modified" in {
      val result = controllers.SimpleResultsController.cachedResult()(FakeRequest().withHeaders((IF_NONE_MATCH, "xx")))
      status(result) mustEqual NOT_MODIFIED
    }

    val securedAreaRequest = FakeRequest(GET, controllers.routes.SecuredActions.securedArea().url)

    "Try to access secured area without credentials" in new WithApplication {
      val result = route(securedAreaRequest).get
      status(result) must equalTo(UNAUTHORIZED)
    }

    "Go to secured area with wrong credentials" in new WithApplication {
      val result = route(securedAreaRequest.withSession("login" -> "istlabs")).get
      status(result) must equalTo(UNAUTHORIZED)
    }

    "Go to secured area with right credentials" in new WithApplication {
      val result = route(securedAreaRequest.withSession("login" -> "gistlabs")).get
      status(result) must equalTo(OK)
      contentAsString(result) must contain(SecuredActions.token)
    }

    "JSON put with wrong headers" in new WithApplication {
      val result = route(FakeRequest(PUT, controllers.routes.JsonController.putValue().url).
        withHeaders(CONTENT_TYPE -> "text/html"), "{\"status\":\"new\"}").get

      status(result) mustNotEqual (OK)
    }

    val jsonTestValue = "new Value"
    val json = Json.obj(
      "jsonTest" -> JsString(jsonTestValue)
    )

    val putReq = FakeRequest(PUT, controllers.routes.JsonController.putValue().url).
      withHeaders(CONTENT_TYPE -> "application/json")

    "JSON put with right headers" in new WithApplication {
      val result = route(putReq, json).get

      status(result) mustEqual (OK)
      contentAsString(result) must contain("status")
      contentAsString(result) must contain("OK")
    }

    "JSON put then get" in new WithApplication {
      route(putReq, json)

      Thread.sleep(1000)

      val getReq = FakeRequest(GET, controllers.routes.JsonController.putValue().url).
        withHeaders(CONTENT_TYPE -> "application/json")

      val result = route(getReq).get

      contentAsString(result) must contain(jsonTestValue)
      status(result) mustEqual (OK)
    }

    "Xml put then get" in new WithApplication {
      route(FakeRequest(PUT, controllers.routes.XmlController.putValue().url).
        withHeaders(CONTENT_TYPE -> "text/xml"), Xml("<xmlTest>test</xmlTest>")).get

      Thread.sleep(1000)

      val result = route(FakeRequest(GET, controllers.routes.XmlController.getValue().url).
        withHeaders(CONTENT_TYPE -> "text/xml")).get

      val data = XML.loadString(contentAsString(result))
      (data \\ "echo").text must equalTo("test")
      status(result) must equalTo(OK)
    }
  }
}

