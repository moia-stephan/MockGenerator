package codes.seanhenry.mockgenerator.generator.templates

import codes.seanhenry.mockgenerator.entities.Initialiser
import codes.seanhenry.mockgenerator.entities.Parameter
import codes.seanhenry.mockgenerator.generator.MockGenerator

class OpenInitialiserTest: MockGeneratorTestTemplate {

  override fun build(generator: MockGenerator) {
    generator.setInitialiser(
        Initialiser(listOf(Parameter("a", "a", "String?", "a: String?")), false)
    )
    generator.setScope("open")
  }

  override fun getExpected(): String {
    return """
      public convenience init() {
      self.init(a: nil)
      }
      """.trimIndent()
  }
}
