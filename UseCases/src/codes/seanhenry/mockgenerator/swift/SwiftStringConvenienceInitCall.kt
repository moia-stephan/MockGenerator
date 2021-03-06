package codes.seanhenry.mockgenerator.swift

import codes.seanhenry.mockgenerator.entities.InitialiserCall
import codes.seanhenry.mockgenerator.util.DefaultValueStore
import codes.seanhenry.mockgenerator.util.OptionalUtil

class SwiftStringConvenienceInitCall {

  val store = DefaultValueStore()

  fun transform(call: InitialiserCall): String {
    if (call.parameters.isEmpty() && call.isFailable) {
      return "super.init()!"
    }
    val forceUnwrap = getForceUnwrap(call)
    val parameters = transformParameters(call).joinToString(", ")
    return "self.init($parameters)$forceUnwrap"
  }

  private fun getForceUnwrap(call: InitialiserCall): String = if (call.isFailable) "!" else ""

  private fun transformParameters(call: InitialiserCall) =
      call.parameters.map {
        val value = getValue(it.label, it.type)
        if (it.label == "_") {
          value
        } else {
          it.label + ": " + value
        }
      }

  private fun getValue(label: String, type: String): String {
    val value = store.getDefaultValue(type)
    if (value != null) {
      return value
    } else if(OptionalUtil.isOptional(type)) {
      return "nil"
    } else {
      return "<#" + label + "#>"
    }
  }
}
