
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/benson/Documents/Projects/tello/scalatello/conf/routes
// @DATE:Mon Sep 30 00:34:49 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def sendRequest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sendRequest",
      """
        function(command0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tello/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("command", encodeURIComponent(command0))})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
