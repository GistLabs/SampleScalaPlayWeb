
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object showUpload extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](_display_(Seq[Any](/*1.2*/{/**
* Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/
})),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*11.2*/main("Simple Forms Example")/*11.30*/ {_display_(Seq[Any](format.raw/*11.32*/("""

<div id="content" class="wrapper doc">

	"""),_display_(Seq[Any](/*15.3*/form(action = routes.Application.upload, 'enctype -> "multipart/form-data")/*15.78*/ {_display_(Seq[Any](format.raw/*15.80*/("""    
    	<input type="file" name="file">    
    	<p>
        	<input type="submit" value ="Send">
    	</p>
    """)))})),format.raw/*20.6*/("""

</div>
""")))})),format.raw/*23.2*/("""
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Nov 25 15:40:47 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/showUpload.scala.html
                    HASH: 1761f21095f995a4d1717ce602940800b136e52f
                    MATRIX: 599->1|888->270|926->290|963->318|1003->320|1082->364|1166->439|1206->441|1352->556|1393->566
                    LINES: 23->1|30->8|32->11|32->11|32->11|36->15|36->15|36->15|41->20|44->23
                    -- GENERATED --
                */
            