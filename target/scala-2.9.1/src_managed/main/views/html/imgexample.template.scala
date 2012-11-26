
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
object imgexample extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/{/**
* Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/
})),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/main("Image Example")/*10.23*/ {_display_(Seq[Any](format.raw/*10.25*/("""

<div id="content" class="wrapper doc">
<h2>Example image: </h2>
	<a href=""""),_display_(Seq[Any](/*14.12*/routes/*14.18*/.Application.index)),format.raw/*14.36*/("""">Back</a>
	<img src=""""),_display_(Seq[Any](/*15.13*/routes/*15.19*/.Assets.at("images/hole.jpg"))),format.raw/*15.48*/("""">
	<a href=""""),_display_(Seq[Any](/*16.12*/routes/*16.18*/.Application.index)),format.raw/*16.36*/("""">Back</a>
</div>

""")))})),format.raw/*19.2*/("""
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Nov 23 20:58:58 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/imgexample.scala.html
                    HASH: d72bf415362f78f86bf1faef344d59dd245baff0
                    MATRIX: 583->1|872->270|910->273|940->294|980->296|1093->373|1108->379|1148->397|1207->420|1222->426|1273->455|1323->469|1338->475|1378->493|1429->513
                    LINES: 22->1|29->8|31->10|31->10|31->10|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|40->19
                    -- GENERATED --
                */
            