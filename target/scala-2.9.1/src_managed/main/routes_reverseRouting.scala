// @SOURCE:/home/alex/java/gistlab/SampleScalaPlayWeb/conf/routes
// @HASH:40cf21aa3282bc32ca660f50af4e5c07d0bd179c
// @DATE:Mon Nov 26 12:10:59 MSK 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:15
def simpleForms() = {
   Call("GET", "/simpleforms.example")
}
                                                        
 
// @LINE:10
def internalServerError() = {
   Call("GET", "/ise.example")
}
                                                        
 
// @LINE:16
def simpleFormsGetSubmit() = {
   Call("GET", "/getsubmit.example")
}
                                                        
 
// @LINE:12
def imgResult() = {
   Call("GET", "/img.example")
}
                                                        
 
// @LINE:13
def echoCookies() = {
   Call("GET", "/echocookies.example")
}
                                                        
 
// @LINE:20
def download(filename:String) = {
   Call("GET", "/hello/" + implicitly[PathBindable[String]].unbind("filename", filename))
}
                                                        
 
// @LINE:19
def upload() = {
   Call("POST", "/upload")
}
                                                        
 
// @LINE:7
def redir() = {
   Call("GET", "/302.example")
}
                                                        
 
// @LINE:17
def simpleFormsPostSubmit() = {
   Call("POST", "/postsubmit.example")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        
 
// @LINE:18
def showUpload() = {
   Call("GET", "/upload.example")
}
                                                        
 
// @LINE:9
def infiniteRedir() = {
   Call("GET", "/302infinite.example")
}
                                                        
 
// @LINE:14
def customCookie() = {
   Call("GET", "/customcookie.example")
}
                                                        
 
// @LINE:8
def strangeResponseCode() = {
   Call("GET", "/466.example")
}
                                                        
 
// @LINE:11
def xmlResult() = {
   Call("GET", "/xml.example")
}
                                                        

                      
    
}
                            

// @LINE:23
class ReverseAssets {
    


 
// @LINE:23
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:15
def simpleForms = JavascriptReverseRoute(
   "controllers.Application.simpleForms",
   """
      function() {
      return _wA({method:"GET", url:"/simpleforms.example"})
      }
   """
)
                                                        
 
// @LINE:10
def internalServerError = JavascriptReverseRoute(
   "controllers.Application.internalServerError",
   """
      function() {
      return _wA({method:"GET", url:"/ise.example"})
      }
   """
)
                                                        
 
// @LINE:16
def simpleFormsGetSubmit = JavascriptReverseRoute(
   "controllers.Application.simpleFormsGetSubmit",
   """
      function() {
      return _wA({method:"GET", url:"/getsubmit.example"})
      }
   """
)
                                                        
 
// @LINE:12
def imgResult = JavascriptReverseRoute(
   "controllers.Application.imgResult",
   """
      function() {
      return _wA({method:"GET", url:"/img.example"})
      }
   """
)
                                                        
 
// @LINE:13
def echoCookies = JavascriptReverseRoute(
   "controllers.Application.echoCookies",
   """
      function() {
      return _wA({method:"GET", url:"/echocookies.example"})
      }
   """
)
                                                        
 
// @LINE:20
def download = JavascriptReverseRoute(
   "controllers.Application.download",
   """
      function(filename) {
      return _wA({method:"GET", url:"/hello/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filename", filename)})
      }
   """
)
                                                        
 
// @LINE:19
def upload = JavascriptReverseRoute(
   "controllers.Application.upload",
   """
      function() {
      return _wA({method:"POST", url:"/upload"})
      }
   """
)
                                                        
 
// @LINE:7
def redir = JavascriptReverseRoute(
   "controllers.Application.redir",
   """
      function() {
      return _wA({method:"GET", url:"/302.example"})
      }
   """
)
                                                        
 
// @LINE:17
def simpleFormsPostSubmit = JavascriptReverseRoute(
   "controllers.Application.simpleFormsPostSubmit",
   """
      function() {
      return _wA({method:"POST", url:"/postsubmit.example"})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        
 
// @LINE:18
def showUpload = JavascriptReverseRoute(
   "controllers.Application.showUpload",
   """
      function() {
      return _wA({method:"GET", url:"/upload.example"})
      }
   """
)
                                                        
 
// @LINE:9
def infiniteRedir = JavascriptReverseRoute(
   "controllers.Application.infiniteRedir",
   """
      function() {
      return _wA({method:"GET", url:"/302infinite.example"})
      }
   """
)
                                                        
 
// @LINE:14
def customCookie = JavascriptReverseRoute(
   "controllers.Application.customCookie",
   """
      function() {
      return _wA({method:"GET", url:"/customcookie.example"})
      }
   """
)
                                                        
 
// @LINE:8
def strangeResponseCode = JavascriptReverseRoute(
   "controllers.Application.strangeResponseCode",
   """
      function() {
      return _wA({method:"GET", url:"/466.example"})
      }
   """
)
                                                        
 
// @LINE:11
def xmlResult = JavascriptReverseRoute(
   "controllers.Application.xmlResult",
   """
      function() {
      return _wA({method:"GET", url:"/xml.example"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:23
class ReverseAssets {
    


 
// @LINE:23
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:15
def simpleForms() = new play.api.mvc.HandlerRef(
   controllers.Application.simpleForms(), HandlerDef(this, "controllers.Application", "simpleForms", Seq())
)
                              
 
// @LINE:10
def internalServerError() = new play.api.mvc.HandlerRef(
   controllers.Application.internalServerError(), HandlerDef(this, "controllers.Application", "internalServerError", Seq())
)
                              
 
// @LINE:16
def simpleFormsGetSubmit() = new play.api.mvc.HandlerRef(
   controllers.Application.simpleFormsGetSubmit(), HandlerDef(this, "controllers.Application", "simpleFormsGetSubmit", Seq())
)
                              
 
// @LINE:12
def imgResult() = new play.api.mvc.HandlerRef(
   controllers.Application.imgResult(), HandlerDef(this, "controllers.Application", "imgResult", Seq())
)
                              
 
// @LINE:13
def echoCookies() = new play.api.mvc.HandlerRef(
   controllers.Application.echoCookies(), HandlerDef(this, "controllers.Application", "echoCookies", Seq())
)
                              
 
// @LINE:20
def download(filename:String) = new play.api.mvc.HandlerRef(
   controllers.Application.download(filename), HandlerDef(this, "controllers.Application", "download", Seq(classOf[String]))
)
                              
 
// @LINE:19
def upload() = new play.api.mvc.HandlerRef(
   controllers.Application.upload(), HandlerDef(this, "controllers.Application", "upload", Seq())
)
                              
 
// @LINE:7
def redir() = new play.api.mvc.HandlerRef(
   controllers.Application.redir(), HandlerDef(this, "controllers.Application", "redir", Seq())
)
                              
 
// @LINE:17
def simpleFormsPostSubmit() = new play.api.mvc.HandlerRef(
   controllers.Application.simpleFormsPostSubmit(), HandlerDef(this, "controllers.Application", "simpleFormsPostSubmit", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              
 
// @LINE:18
def showUpload() = new play.api.mvc.HandlerRef(
   controllers.Application.showUpload(), HandlerDef(this, "controllers.Application", "showUpload", Seq())
)
                              
 
// @LINE:9
def infiniteRedir() = new play.api.mvc.HandlerRef(
   controllers.Application.infiniteRedir(), HandlerDef(this, "controllers.Application", "infiniteRedir", Seq())
)
                              
 
// @LINE:14
def customCookie() = new play.api.mvc.HandlerRef(
   controllers.Application.customCookie(), HandlerDef(this, "controllers.Application", "customCookie", Seq())
)
                              
 
// @LINE:8
def strangeResponseCode() = new play.api.mvc.HandlerRef(
   controllers.Application.strangeResponseCode(), HandlerDef(this, "controllers.Application", "strangeResponseCode", Seq())
)
                              
 
// @LINE:11
def xmlResult() = new play.api.mvc.HandlerRef(
   controllers.Application.xmlResult(), HandlerDef(this, "controllers.Application", "xmlResult", Seq())
)
                              

                      
    
}
                            

// @LINE:23
class ReverseAssets {
    


 
// @LINE:23
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                