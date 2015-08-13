package com.payalabs.scalajs.react.mdl

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.ReactTag
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js

object MaterialComponent {
  type ScopeType = ComponentScopeM[(ReactTag, Boolean), Unit, Unit, TopNode]

  val rc = ReactComponentB[(ReactTag, Boolean)]("MaterialComponent")
    .render(props => props._1)
    .componentDidMount(afterMount)
    .componentDidUpdate(afterUpdate)
    .build

  def apply(props: (ReactTag, Boolean)): ReactComponentU[(ReactTag, Boolean), Unit, Unit, TopNode] = {
    rc(props)
  }

  private def upgrade(scope: ScopeType): Unit = {
    js.Dynamic.global.Material.componentHandler.upgradeElement(scope.getDOMNode())
    if (scope.props._2) {
      val children = scope.getDOMNode().children
      (0 until children.length).foreach(i =>
        js.Dynamic.global.Material.componentHandler.upgradeElement(children(i))
      )
    }
  }

  def afterMount(scope: ScopeType): Unit = {
    upgrade(scope)
  }

  def afterUpdate(scope: ScopeType, props: (ReactTag, Boolean), state: Unit): Unit = {
    upgrade(scope)
  }
}