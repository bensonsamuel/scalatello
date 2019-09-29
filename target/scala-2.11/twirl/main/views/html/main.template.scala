
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String, nav: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.45*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        """),format.raw/*13.62*/("""
        """),format.raw/*14.9*/("""<title>"""),_display_(/*14.17*/title),format.raw/*14.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*15.54*/routes/*15.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*15.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.59*/routes/*16.65*/.Assets.versioned("images/favicon.png")),format.raw/*16.104*/("""">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">


    </head>
    <body>
        """),format.raw/*23.32*/("""
    """),format.raw/*24.5*/("""<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">mtXs</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
        data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item """),_display_(/*32.38*/if(nav == "home")/*32.55*/{_display_(Seq[Any](format.raw/*32.56*/("""active""")))}),format.raw/*32.63*/("""">
                    <a class="nav-link" href="/">Home """),_display_(/*33.56*/if(nav == "home")/*33.73*/{_display_(Seq[Any](format.raw/*33.74*/("""<span class="sr-only">(current)</span>""")))}),format.raw/*33.113*/("""</a>
                </li>
                <li class="nav-item """),_display_(/*35.38*/if(nav == "exchange" || nav == "loggedin/exchange")/*35.89*/{_display_(Seq[Any](format.raw/*35.90*/("""active""")))}),format.raw/*35.97*/("""">
                    <a class="nav-link" href="/exchange">Exchange """),_display_(/*36.68*/if(nav == "exchange" || nav == "loggedin/exchange")/*36.119*/{_display_(Seq[Any](format.raw/*36.120*/("""<span class="sr-only">(current)</span>""")))}),format.raw/*36.159*/("""</a>
                </li>
                    <li class="nav-item """),_display_(/*38.42*/if(nav == "login" || nav == "signup")/*38.79*/ {_display_(Seq[Any](format.raw/*38.81*/("""active""")))}),format.raw/*38.88*/("""">
                        <a class="nav-link" href="/login">Login/ Signup
                            """),_display_(/*40.30*/if(nav == "login" || nav == "signup")/*40.67*/ {_display_(Seq[Any](format.raw/*40.69*/("""
                                """),format.raw/*41.33*/("""<span class="sr-only">(current)</span>
                            """)))}),format.raw/*42.30*/("""</a>
                    </li>
            </ul>
        </div>
    </nav>

    <main role="main" class="container" ng-app="Xapp">
        """),_display_(/*49.10*/content),format.raw/*49.17*/("""
    """),format.raw/*50.5*/("""</main>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
        <script src=""""),_display_(/*56.23*/routes/*56.29*/.Assets.versioned("javascripts/reconnecting-websocket.min.js")),format.raw/*56.91*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*57.23*/routes/*57.29*/.Assets.versioned("javascripts/hello.js")),format.raw/*57.70*/("""" type="text/javascript"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,nav:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,nav)(content)

  def f:((String,String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,nav) => (content) => apply(title,nav)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 30 00:14:48 IST 2019
                  SOURCE: /Users/benson/Documents/Projects/tello/scalatello/app/views/main.scala.html
                  HASH: e447d784c6abd63f6e3e981de806da7bc8ae7b23
                  MATRIX: 994->260|1132->303|1160->305|1335->505|1371->514|1406->522|1432->527|1521->589|1536->595|1599->636|1687->697|1702->703|1763->742|2043->1084|2075->1089|2639->1626|2665->1643|2704->1644|2742->1651|2827->1709|2853->1726|2892->1727|2963->1766|3054->1830|3114->1881|3153->1882|3191->1889|3288->1959|3349->2010|3389->2011|3460->2050|3555->2118|3601->2155|3641->2157|3679->2164|3810->2268|3856->2305|3896->2307|3957->2340|4056->2408|4223->2548|4251->2555|4283->2560|5044->3294|5059->3300|5142->3362|5226->3419|5241->3425|5303->3466
                  LINES: 26->7|31->7|33->9|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|46->23|47->24|55->32|55->32|55->32|55->32|56->33|56->33|56->33|56->33|58->35|58->35|58->35|58->35|59->36|59->36|59->36|59->36|61->38|61->38|61->38|61->38|63->40|63->40|63->40|64->41|65->42|72->49|72->49|73->50|79->56|79->56|79->56|80->57|80->57|80->57
                  -- GENERATED --
              */
          