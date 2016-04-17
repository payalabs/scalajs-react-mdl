package com.payalabs.scalajs.react

import japgolly.scalajs.react.{TopNode, ReactComponentU}
import japgolly.scalajs.react.vdom.all._

package object mdl {
  implicit class MaterialAble(val elem: ReactTag) extends AnyVal {
    def material: ReactComponentU[(ReactTag, Boolean), Unit, Unit, TopNode] = {
      MaterialComponent((elem, false))
    }

    def material(children: Boolean): ReactComponentU[(ReactTag, Boolean), Unit, Unit, TopNode] = {
      MaterialComponent((elem, children))
    }
  }
}
