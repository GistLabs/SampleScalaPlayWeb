
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
object simpleforms extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Client],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(clientForm: Form[Client]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.28*/("""

"""),_display_(Seq[Any](/*3.2*/{/**
* Copyright (C) 2012 Gist Labs, LLC. (http://gistlabs.com)
*
* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/.
*/
})),format.raw/*10.2*/("""

"""),_display_(Seq[Any](/*13.2*/main("Simple Forms Example")/*13.30*/ {_display_(Seq[Any](format.raw/*13.32*/("""

<div id="content" class="wrapper doc">

<h2>Get Form Example: </h2>	
	"""),_display_(Seq[Any](/*18.3*/helper/*18.9*/.form(action = routes.Application.simpleFormsGetSubmit)/*18.64*/ {_display_(Seq[Any](format.raw/*18.66*/("""
    	<input type="text" name="name"/>
    	<input type="submit" value="Send Data"/>
	""")))})),format.raw/*21.3*/("""
<br/><br/>	
	
<h2>Post Form Example: </h2>
	"""),_display_(Seq[Any](/*25.3*/helper/*25.9*/.form(action = routes.Application.simpleFormsPostSubmit)/*25.65*/ {_display_(Seq[Any](format.raw/*25.67*/("""
    	"""),_display_(Seq[Any](/*26.7*/helper/*26.13*/.inputText(clientForm("username")))),format.raw/*26.47*/("""    
    	"""),_display_(Seq[Any](/*27.7*/helper/*27.13*/.inputText(clientForm("firstname")))),format.raw/*27.48*/("""
    	"""),_display_(Seq[Any](/*28.7*/helper/*28.13*/.inputText(clientForm("lastname")))),format.raw/*28.47*/("""
    	
	
	<div class="actions">
    	<input type="submit" class="btn primary" value="Send Data">
    </div>	
    """)))})),format.raw/*34.6*/("""
	<a href=""""),_display_(Seq[Any](/*35.12*/routes/*35.18*/.Application.index)),format.raw/*35.36*/("""">Back</a>
</div>
""")))})),format.raw/*37.2*/("""
"""))}
    }
    
    def render(clientForm:Form[Client]) = apply(clientForm)
    
    def f:((Form[Client]) => play.api.templates.Html) = (clientForm) => apply(clientForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Nov 23 23:40:41 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/simpleforms.scala.html
                    HASH: 334a08aad75b53c07c7080d90c2f54f5bfd3e356
                    MATRIX: 517->1|636->27|673->30|963->299|1001->319|1038->347|1078->349|1186->422|1200->428|1264->483|1304->485|1422->572|1503->618|1517->624|1582->680|1622->682|1664->689|1679->695|1735->729|1781->740|1796->746|1853->781|1895->788|1910->794|1966->828|2111->942|2159->954|2174->960|2214->978|2264->997
                    LINES: 19->1|23->1|25->3|32->10|34->13|34->13|34->13|39->18|39->18|39->18|39->18|42->21|46->25|46->25|46->25|46->25|47->26|47->26|47->26|48->27|48->27|48->27|49->28|49->28|49->28|55->34|56->35|56->35|56->35|58->37
                    -- GENERATED --
                */
            