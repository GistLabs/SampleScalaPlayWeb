
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
object fileuploads extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Client],play.api.templates.Html] {

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

"""),_display_(Seq[Any](/*13.2*/main("File Upload Example")/*13.29*/ {_display_(Seq[Any](format.raw/*13.31*/("""

<div id="content" class="wrapper doc">

<h2>File upload: </h2>	
	"""),_display_(Seq[Any](/*18.3*/form(action = routes.Application.upload, 'enctype -> "multipart/form-data")/*18.78*/ {_display_(Seq[Any](format.raw/*18.80*/("""   
    	<input type="file" name="file">    
    	<p>
        	<input type="submit">
    	</p>    
	""")))})),format.raw/*23.3*/("""
	
	<a href=""""),_display_(Seq[Any](/*25.12*/routes/*25.18*/.Application.index)),format.raw/*25.36*/("""">Back</a>
</div>
""")))})),format.raw/*27.2*/("""
"""))}
    }
    
    def render(clientForm:Form[Client]) = apply(clientForm)
    
    def f:((Form[Client]) => play.api.templates.Html) = (clientForm) => apply(clientForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 24 00:51:23 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/fileuploads.scala.html
                    HASH: 1dee3146d3480d876d24a1938886b8bb681adf01
                    MATRIX: 517->1|636->27|673->30|963->299|1001->319|1037->346|1077->348|1180->416|1264->491|1304->493|1436->594|1486->608|1501->614|1541->632|1591->651
                    LINES: 19->1|23->1|25->3|32->10|34->13|34->13|34->13|39->18|39->18|39->18|44->23|46->25|46->25|46->25|48->27
                    -- GENERATED --
                */
            