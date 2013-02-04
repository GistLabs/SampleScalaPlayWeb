/**
 * Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import controllers.FilesController
import java.io.File
import play.api._


object Global extends GlobalSettings {
  override def onStart(app: Application) {
   val tmpFolder = FilesController.getTmpFolder(app)
   val status = tmpFolder.mkdir()
   if (!status){
      FilesController.deleteFilesFromFolder(tmpFolder)
   }
  }

  override def onStop(app: Application) {
      FilesController.deleteFilesFromTempFolder(app)
  }
}
