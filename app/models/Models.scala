/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */


package models

//models layer is thin as no any DB used

// Reference & NesletterFrequency implemented as List though Enumeration would be more precise
object Reference {
  val list = List(
    "Search Engine",
    "Friend",
    "Media",
    "Other"
  )
}

object NewsletterFrequency {
  val list = List(
    "Weekly",
    "Monthly",
    "None"
  )
}


case class Client(
                   username: String,
                   firstname: String,
                   lastname: String
                   )

case class User(
                 login: String,
                 password: String,
                 email: String,
                 reference: String,
                 newsletter:String
               )

