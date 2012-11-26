
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
object showSimpleFormsResult extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Map[String, String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(data:Map[String,String]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.27*/("""

"""),_display_(Seq[Any](/*3.2*/{/**
* Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/
})),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*13.2*/main("Form result")/*13.21*/ {_display_(Seq[Any](format.raw/*13.23*/("""

<div id="content" class="wrapper doc">
<h3>Form Data Application Got: </h3>
<table width="50%">
    """),_display_(Seq[Any](/*18.6*/for((k,v)<-data) yield /*18.22*/{_display_(Seq[Any](format.raw/*18.23*/("""
	<tr>
	    <td width="1px" align="left">"""),_display_(Seq[Any](/*20.36*/k)),format.raw/*20.37*/("""</td><td width="1px" align="left">"""),_display_(Seq[Any](/*20.72*/v)),format.raw/*20.73*/("""</td>
	<tr>
    """)))})),format.raw/*22.6*/("""
</table>

<a href=""""),_display_(Seq[Any](/*25.11*/routes/*25.17*/.Application.index)),format.raw/*25.35*/("""">Back</a>
</div>
""")))})),format.raw/*27.2*/("""
"""))}
    }
    
    def render(data:Map[String, String]) = apply(data)
    
    def f:((Map[String, String]) => play.api.templates.Html) = (data) => apply(data)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 24 00:51:23 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/showSimpleFormsResult.scala.html
                    HASH: 9cde47d1400318f0c588ccdda4896ef9073e8f06
                    MATRIX: 534->1|652->26|689->29|979->298|1017->318|1045->337|1085->339|1223->442|1255->458|1294->459|1372->501|1395->502|1466->537|1489->538|1537->555|1594->576|1609->582|1649->600|1699->619
                    LINES: 19->1|23->1|25->3|32->10|34->13|34->13|34->13|39->18|39->18|39->18|41->20|41->20|41->20|41->20|43->22|46->25|46->25|46->25|48->27
                    -- GENERATED --
                */
            