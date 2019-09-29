
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template takes a single argument, a String containing a
 * message to display.
 */
  def apply/*5.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.19*/("""

"""),format.raw/*11.4*/("""
"""),_display_(/*12.2*/main("Welcome to ScalaTello", "home")/*12.39*/ {_display_(Seq[Any](format.raw/*12.41*/("""

    """),format.raw/*17.8*/("""
    """),format.raw/*18.44*/("""


        """),format.raw/*21.9*/("""<div class="jumbotron">
            <h1>Navbar example</h1>
            <p class="lead">This example is a quick exercise to illustrate how fixed to top navbar works. As you scroll, it will remain fixed to the top of your browser's viewport.</p>
            <a class="btn btn-lg btn-primary" href="../../components/navbar/" role="button">View navbar docs &raquo;</a>
        </div>

    <style>
            /* Show it is fixed to the top */
            body """),format.raw/*29.18*/("""{"""),format.raw/*29.19*/("""
                """),format.raw/*30.17*/("""min-height: 75rem;
                padding-top: 4.5rem;
            """),format.raw/*32.13*/("""}"""),format.raw/*32.14*/("""
    """),format.raw/*33.5*/("""</style>
""")))}),format.raw/*34.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Sep 30 00:10:11 IST 2019
                  SOURCE: /Users/benson/Documents/Projects/tello/scalatello/app/views/index.scala.html
                  HASH: 4b2dac714da6643a063024c86de5281287781548
                  MATRIX: 818->95|930->112|959->308|987->310|1033->347|1073->349|1106->478|1139->522|1177->533|1662->990|1691->991|1736->1008|1832->1076|1861->1077|1893->1082|1933->1092
                  LINES: 24->5|29->5|31->11|32->12|32->12|32->12|34->17|35->18|38->21|46->29|46->29|47->30|49->32|49->32|50->33|51->34
                  -- GENERATED --
              */
          