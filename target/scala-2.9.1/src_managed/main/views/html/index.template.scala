
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

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

"""),_display_(Seq[Any](/*10.2*/main("Index Page")/*10.20*/ {_display_(Seq[Any](format.raw/*10.22*/("""

<div id="content" class="wrapper doc">
<h2>Example pages list: </h2>
 <ul>    
 			<h3>Different response codes:</h3>
                <li><a href=""""),_display_(Seq[Any](/*16.31*/routes/*16.37*/.Application.redir)),format.raw/*16.55*/("""">302 Redirect Example</a></li>
                <li><a href=""""),_display_(Seq[Any](/*17.31*/routes/*17.37*/.Application.infiniteRedir)),format.raw/*17.63*/("""">302 Infinite Redirect Example</a></li>
                <li><a href=""""),_display_(Seq[Any](/*18.31*/routes/*18.37*/.Application.strangeResponseCode)),format.raw/*18.69*/("""">Strange Response Code(466) Example</a></li> 
                <li><a href=""""),_display_(Seq[Any](/*19.31*/routes/*19.37*/.Application.internalServerError)),format.raw/*19.69*/("""">Internal Server Error Example</a></li>
             <br/><br/>   
             
             <h3>Different resulting data:</h3>    
                <li><a href=""""),_display_(Seq[Any](/*23.31*/routes/*23.37*/.Application.xmlResult)),format.raw/*23.59*/("""">Simple XML Example</a></li>
                <li><a href=""""),_display_(Seq[Any](/*24.31*/routes/*24.37*/.Application.imgResult)),format.raw/*24.59*/("""">Image Example</a></li>
                <li><a href=""""),_display_(Seq[Any](/*25.31*/routes/*25.37*/.Application.echoCookies)),format.raw/*25.61*/("""">Echo Cookies Example</a></li>
                <li><a href=""""),_display_(Seq[Any](/*26.31*/routes/*26.37*/.Application.customCookie)),format.raw/*26.62*/("""">Custom cookie Example</a></li>
                
             <h3>Forms:</h3> 
             	<li><a href=""""),_display_(Seq[Any](/*29.29*/routes/*29.35*/.Application.simpleForms)),format.raw/*29.59*/("""">Simple Forms(GET&POST) Example</a></li>
             	<li><a href=""""),_display_(Seq[Any](/*30.29*/routes/*30.35*/.Application.simpleForms)),format.raw/*30.59*/("""">Advanced Form Example</a></li>
             	<li><a href=""""),_display_(Seq[Any](/*31.29*/routes/*31.35*/.Application.showUpload)),format.raw/*31.58*/("""">File Upload Example</a></li>
             <br/><br/>
                
            </ul>
            
	
</div>

""")))})),format.raw/*39.2*/("""
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Nov 26 10:23:46 MSK 2012
                    SOURCE: /home/alex/java/gistlab/SampleScalaPlayWeb/app/views/index.scala.html
                    HASH: 5e09f1c877df6f3464c32644a7303d6eb4bd52e2
                    MATRIX: 578->1|867->270|905->273|932->291|972->293|1158->443|1173->449|1213->467|1311->529|1326->535|1374->561|1481->632|1496->638|1550->670|1663->747|1678->753|1732->785|1932->949|1947->955|1991->977|2087->1037|2102->1043|2146->1065|2237->1120|2252->1126|2298->1150|2396->1212|2411->1218|2458->1243|2602->1351|2617->1357|2663->1381|2769->1451|2784->1457|2830->1481|2927->1542|2942->1548|2987->1571|3132->1685
                    LINES: 22->1|29->8|31->10|31->10|31->10|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|44->23|44->23|44->23|45->24|45->24|45->24|46->25|46->25|46->25|47->26|47->26|47->26|50->29|50->29|50->29|51->30|51->30|51->30|52->31|52->31|52->31|60->39
                    -- GENERATED --
                */
            