package com.payalabs.scalajs.react.mdl

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.vdom.all
import org.scalajs.dom

import scala.scalajs.js

object Example extends js.JSApp {
  def main(): Unit = {
    val component = ReactComponentB[Unit]("ShowcaseApp").render { _ =>
      div(
        a(href := "https://github.com/payalabs/scalajs-react-mdl")(
          img(
            position := "absolute",
            top := "0px",
            right := "0px",
            border := "0px",
            zIndex := "1000",
            src := "https://camo.githubusercontent.com/652c5b9acfaddf3a9c326fa6bde407b87f7be0f4/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f6f72616e67655f6666373630302e706e67",
            alt := "Fork me on GitHub",
            "data-canonical-src".reactAttr := "https://s3.amazonaws.com/github/ribbons/forkme_right_orange_ff7600.png"
          )
        ),
        div(className := "mdl-layout mdl-js-layout mdl-layout--fixed-header")(
          header(className := "mdl-layout__header")(
            div(className := "mdl-layout__header-row")(
              span(className := "mdl-layout-title")("scalajs-react-mdl"),
              div(className := "mdl-layout-spacer")
            )
          ),
          all.main(className := "mdl-layout__content")(
            div(className := "mdl-grid")(
              div(className := "mdl-cell mdl-cell--2-col"),
              div(className := "mdl-cell mdl-cell--8-col")(
                h2(
                  "Examples components using ",
                  a(href := "http://github.com/payalabs/scalajs-react-mdl")("scalajs-react-mdl")
                ),
                h3("FAB with ripple"),
                button(className := "mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored")(
                  i(className := "material-icons")("add")
                ).material,
                h3("Accent colored button with ripple"),
                button(className := "mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent")(
                  "I am a button"
                ).material,
                h3("Indeterminate progress bar"),
                div(className := "mdl-progress mdl-js-progress mdl-progress__indeterminate progress-demo").material,
                h3("Default spinner"),
                div(className := "mdl-spinner mdl-js-spinner is-active").material,
                h3("Slider"),
                input(className := "mdl-slider mdl-js-slider", `type` := "range",
                  "min".reactAttr := "0", "max".reactAttr := "100").material,
                h3("Numeric textfield with floating label"),
                div(className := "mdl-textfield mdl-js-textfield mdl-textfield--floating-label", width := "100px")(
                  input(className := "mdl-textfield__input", `type` := "number", id := "sample-textfield-number"),
                  label(className := "mdl-textfield__label", `for` := "sample-textfield-number")("Number...")
                ).material,
                h3("Email textfield with floating label"),
                div(className := "mdl-textfield mdl-js-textfield mdl-textfield--floating-label", width := "100px")(
                  input(className := "mdl-textfield__input", `type` := "email", id := "sample-textfield-email"),
                  label(className := "mdl-textfield__label", `for` := "sample-textfield-email")("Email..."),
                  span(className := "mdl-textfield__error", display := "flex")("Not an email!")
                ).material
              )
            )
          )
        ).material
      )
    }.build()

    ReactDOM.render(component, dom.document.getElementById("main-content"))
  }
}
