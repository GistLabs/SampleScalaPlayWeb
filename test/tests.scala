/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class ControllersSpec extends Specification {
	"index action" in {
  		val result = controllers.Application.index()(FakeRequest())
  		status(result) must equalTo(OK)
  		contentType(result) must beSome("text/html")
  		charset(result) must beSome("utf-8")
	}

  "infinite redirect action" in {
    val result = controllers.Application.infiniteRedir()(FakeRequest())
    status(result) must  beBetween(300, 399)
  }

  "Internal Server Error" in {
    val result = controllers.Application.internalServerError()(FakeRequest())
    status(result) must  beBetween(500, 599)
  }


}