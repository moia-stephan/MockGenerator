package codes.seanhenry.mockgenerator.usecases

import junit.framework.TestCase
import org.junit.Assert

class CreateInvocationCountTest: TestCase() {

  fun testTransformsToProperty() {
    val createCount = CreateInvocationCount()
    val property = createCount.transform("name")
    Assert.assertEquals("invokedNameCount", property.name)
    Assert.assertEquals("Int", property.type)
  }

  fun testTransformsToPropertyWithLongName() {
    val createCount = CreateInvocationCount()
    val property = createCount.transform("longName")
    Assert.assertEquals("invokedLongNameCount", property.name)
  }

  fun testTransformsToPropertyWithCapitalizedName() {
    val createCount = CreateInvocationCount()
    val property = createCount.transform("URL")
    Assert.assertEquals("invokedURLCount", property.name)
  }
}
