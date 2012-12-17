/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import org.specs2.mutable._
import play.api.libs.Files.TemporaryFile
import play.api.mvc.{MultipartFormData, Cookie}
import play.api.mvc.MultipartFormData.FilePart
import play.api.Play
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
    status(result) must  beBetween(300, 399)
  }

  "Internal Server Error" in {
    val result = controllers.ResponseCodesController.internalServerError()(FakeRequest())
    status(result) must  beBetween(500, 599)
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
        withCookies(new Cookie("test","test")), "").get

      val cookies = header(SET_COOKIE,result).getOrElse("")

      status(result) must equalTo(OK)
      cookies must contain("test")
    }
  }
}