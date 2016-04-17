package com.payalabs.scalajs.react.mdl

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js

object MaterialComponent {
  val rc = ReactComponentB[(ReactTag, Boolean)]("MaterialComponent")
    .render($ => $.props._1)
    .componentDidMount($ => upgrade($.props, $.getDOMNode()))
    .componentDidUpdate(u => upgrade(u.$.props, u.$.getDOMNode()))
    .build

  def apply(props: (ReactTag, Boolean)): ReactComponentU[(ReactTag, Boolean), Unit, Unit, TopNode] = {
    rc(props)
  }

  private def upgrade(props: (ReactTag, Boolean), top: TopNode) = Callback {
    js.Dynamic.global.componentHandler.upgradeElement(top)
    if (props._2) {
      val children = top.children
      (0 until children.length).foreach(i =>
        js.Dynamic.global.Material.componentHandler.upgradeElement(children(i))
      )
    }
  }
}
