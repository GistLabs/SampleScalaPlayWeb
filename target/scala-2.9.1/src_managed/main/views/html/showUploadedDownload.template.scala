
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
object showUploadedDownload extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(filename:String):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/{/**
* Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/
})),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*13.2*/main("Download Uploaded File")/*13.32*/ {_display_(Seq[Any](format.raw/*13.34*/("""

<div id="content" class="wrapper doc">

	<a href=""""),_display_(Seq[Any](/*17.12*/routes/*17.18*/.Application.download(filename))),format.raw/*17.49*/("""">Download """),_display_(Seq[Any](/*17.61*/filename)),format.raw/*17.69*/("""</a>

</div>
""")))})),format.raw/*20.2*/("""
"""))}
    }
    
    def render(filename:String) = apply(filename)
    
    def f:((String) => play.api.templates.Html) = (filename) => apply(filename)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 26 12:11:16 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/showUploadedDownload.scala.html
                    HASH: 37afdd557c64d649d525b4bdef870155c9a0aca4
                    MATRIX: 520->1|630->18|667->21|957->290|995->310|1034->340|1074->342|1163->395|1178->401|1231->432|1279->444|1309->452|1354->466
                    LINES: 19->1|23->1|25->3|32->10|34->13|34->13|34->13|38->17|38->17|38->17|38->17|38->17|41->20
                    -- GENERATED --
                */
            