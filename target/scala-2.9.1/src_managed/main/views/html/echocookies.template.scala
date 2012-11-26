
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
object echocookies extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(cookies: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/{/**
* Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/
})),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*12.2*/main("Echo Cookies example")/*12.30*/ {_display_(Seq[Any](format.raw/*12.32*/("""

<div id="content" class="wrapper doc">
<h3>Cookies got: </h3>
    """),_display_(Seq[Any](/*16.6*/cookies)),format.raw/*16.13*/("""
    
    <p><a href=""""),_display_(Seq[Any](/*18.18*/routes/*18.24*/.Application.index)),format.raw/*18.42*/("""">Back</a></p>
</div>

""")))})),format.raw/*21.2*/("""
"""))}
    }
    
    def render(cookies:String) = apply(cookies)
    
    def f:((String) => play.api.templates.Html) = (cookies) => apply(cookies)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Nov 23 20:58:58 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/echocookies.scala.html
                    HASH: 93a855ba1879b9e78420297e402d6ddfa1cc1e35
                    MATRIX: 511->1|605->18|642->21|932->290|970->293|1007->321|1047->323|1151->392|1180->399|1239->422|1254->428|1294->446|1349->470
                    LINES: 19->1|22->1|24->3|31->10|33->12|33->12|33->12|37->16|37->16|39->18|39->18|39->18|42->21
                    -- GENERATED --
                */
            