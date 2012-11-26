// @SOURCE:/home/alex/java/gistlab/SampleScalaPlayWeb/conf/routes
// @HASH:40cf21aa3282bc32ca660f50af4e5c07d0bd179c
// @DATE:Mon Nov 26 12:10:59 MSK 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:7
val controllers_Application_redir1 = Route("GET", PathPattern(List(StaticPart("/302.example"))))
                    

// @LINE:8
val controllers_Application_strangeResponseCode2 = Route("GET", PathPattern(List(StaticPart("/466.example"))))
                    

// @LINE:9
val controllers_Application_infiniteRedir3 = Route("GET", PathPattern(List(StaticPart("/302infinite.example"))))
                    

// @LINE:10
val controllers_Application_internalServerError4 = Route("GET", PathPattern(List(StaticPart("/ise.example"))))
                    

// @LINE:11
val controllers_Application_xmlResult5 = Route("GET", PathPattern(List(StaticPart("/xml.example"))))
                    

// @LINE:12
val controllers_Application_imgResult6 = Route("GET", PathPattern(List(StaticPart("/img.example"))))
                    

// @LINE:13
val controllers_Application_echoCookies7 = Route("GET", PathPattern(List(StaticPart("/echocookies.example"))))
                    

// @LINE:14
val controllers_Application_customCookie8 = Route("GET", PathPattern(List(StaticPart("/customcookie.example"))))
                    

// @LINE:15
val controllers_Application_simpleForms9 = Route("GET", PathPattern(List(StaticPart("/simpleforms.example"))))
                    

// @LINE:16
val controllers_Application_simpleFormsGetSubmit10 = Route("GET", PathPattern(List(StaticPart("/getsubmit.example"))))
                    

// @LINE:17
val controllers_Application_simpleFormsPostSubmit11 = Route("POST", PathPattern(List(StaticPart("/postsubmit.example"))))
                    

// @LINE:18
val controllers_Application_showUpload12 = Route("GET", PathPattern(List(StaticPart("/upload.example"))))
                    

// @LINE:19
val controllers_Application_upload13 = Route("POST", PathPattern(List(StaticPart("/upload"))))
                    

// @LINE:20
val controllers_Application_download14 = Route("GET", PathPattern(List(StaticPart("/hello/"),DynamicPart("filename", """[^/]+"""))))
                    

// @LINE:23
val controllers_Assets_at15 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index"""),("""GET""","""/302.example""","""controllers.Application.redir"""),("""GET""","""/466.example""","""controllers.Application.strangeResponseCode"""),("""GET""","""/302infinite.example""","""controllers.Application.infiniteRedir"""),("""GET""","""/ise.example""","""controllers.Application.internalServerError"""),("""GET""","""/xml.example""","""controllers.Application.xmlResult"""),("""GET""","""/img.example""","""controllers.Application.imgResult"""),("""GET""","""/echocookies.example""","""controllers.Application.echoCookies"""),("""GET""","""/customcookie.example""","""controllers.Application.customCookie"""),("""GET""","""/simpleforms.example""","""controllers.Application.simpleForms"""),("""GET""","""/getsubmit.example""","""controllers.Application.simpleFormsGetSubmit"""),("""POST""","""/postsubmit.example""","""controllers.Application.simpleFormsPostSubmit"""),("""GET""","""/upload.example""","""controllers.Application.showUpload"""),("""POST""","""/upload""","""controllers.Application.upload"""),("""GET""","""/hello/$filename<[^/]+>""","""controllers.Application.download(filename:String)"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:7
case controllers_Application_redir1(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.redir, HandlerDef(this, "controllers.Application", "redir", Nil))
   }
}
                    

// @LINE:8
case controllers_Application_strangeResponseCode2(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.strangeResponseCode, HandlerDef(this, "controllers.Application", "strangeResponseCode", Nil))
   }
}
                    

// @LINE:9
case controllers_Application_infiniteRedir3(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.infiniteRedir, HandlerDef(this, "controllers.Application", "infiniteRedir", Nil))
   }
}
                    

// @LINE:10
case controllers_Application_internalServerError4(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.internalServerError, HandlerDef(this, "controllers.Application", "internalServerError", Nil))
   }
}
                    

// @LINE:11
case controllers_Application_xmlResult5(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.xmlResult, HandlerDef(this, "controllers.Application", "xmlResult", Nil))
   }
}
                    

// @LINE:12
case controllers_Application_imgResult6(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.imgResult, HandlerDef(this, "controllers.Application", "imgResult", Nil))
   }
}
                    

// @LINE:13
case controllers_Application_echoCookies7(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.echoCookies, HandlerDef(this, "controllers.Application", "echoCookies", Nil))
   }
}
                    

// @LINE:14
case controllers_Application_customCookie8(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.customCookie, HandlerDef(this, "controllers.Application", "customCookie", Nil))
   }
}
                    

// @LINE:15
case controllers_Application_simpleForms9(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.simpleForms, HandlerDef(this, "controllers.Application", "simpleForms", Nil))
   }
}
                    

// @LINE:16
case controllers_Application_simpleFormsGetSubmit10(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.simpleFormsGetSubmit, HandlerDef(this, "controllers.Application", "simpleFormsGetSubmit", Nil))
   }
}
                    

// @LINE:17
case controllers_Application_simpleFormsPostSubmit11(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.simpleFormsPostSubmit, HandlerDef(this, "controllers.Application", "simpleFormsPostSubmit", Nil))
   }
}
                    

// @LINE:18
case controllers_Application_showUpload12(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.showUpload, HandlerDef(this, "controllers.Application", "showUpload", Nil))
   }
}
                    

// @LINE:19
case controllers_Application_upload13(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.upload, HandlerDef(this, "controllers.Application", "upload", Nil))
   }
}
                    

// @LINE:20
case controllers_Application_download14(params) => {
   call(params.fromPath[String]("filename", None)) { (filename) =>
        invokeHandler(_root_.controllers.Application.download(filename), HandlerDef(this, "controllers.Application", "download", Seq(classOf[String])))
   }
}
                    

// @LINE:23
case controllers_Assets_at15(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                