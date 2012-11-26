
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(subtitle:String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""
"""),_display_(Seq[Any](/*2.2*/{/**
* Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/
})),format.raw/*9.2*/("""

<!DOCTYPE html>

<html>
<head>
<title>"""),_display_(Seq[Any](/*15.9*/subtitle)),format.raw/*15.17*/(""" - Sample Scala+Play Web Application to Test Mechanize</title>
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*16.46*/routes/*16.52*/.Assets.at("stylesheets/main.css"))),format.raw/*16.86*/("""">
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*17.51*/routes/*17.57*/.Assets.at("images/favicon.png"))),format.raw/*17.89*/("""">
<script src=""""),_display_(Seq[Any](/*18.15*/routes/*18.21*/.Assets.at(" javascripts/jquery-1.7.1.min.js"))),format.raw/*18.67*/("""" type="text/javascript"></script>
</head>
<body>
	<section id="top">
		<div class="wrapper">
			<h1>
				<a href=""""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Application.index)),format.raw/*24.39*/("""">Home</a>
			</h1>
		</div>
	</section>
	
	"""),_display_(Seq[Any](/*29.3*/content)),format.raw/*29.10*/("""
</body>
</html>
"""))}
    }
    
    def render(subtitle:String,content:Html) = apply(subtitle)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (subtitle) => (content) => apply(subtitle)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 26 11:51:04 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/main.scala.html
                    HASH: 7d88f056ab1a57db02bb6d21e14bdc88347f4f7f
                    MATRIX: 509->1|618->33|654->35|943->304|1019->345|1049->353|1193->461|1208->467|1264->501|1353->554|1368->560|1422->592|1475->609|1490->615|1558->661|1710->777|1725->783|1765->801|1845->846|1874->853
                    LINES: 19->1|22->1|23->2|30->9|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|45->24|45->24|45->24|50->29|50->29
                    -- GENERATED --
                */
            