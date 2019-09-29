
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/benson/Documents/Projects/tello/scalatello/conf/routes
// @DATE:Mon Sep 30 00:34:49 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
