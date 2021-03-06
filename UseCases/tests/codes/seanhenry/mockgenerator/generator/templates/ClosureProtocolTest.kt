package codes.seanhenry.mockgenerator.generator.templates

import codes.seanhenry.mockgenerator.entities.ProtocolMethod
import codes.seanhenry.mockgenerator.generator.MockGenerator

class ClosureProtocolTest : MockGeneratorTestTemplate {

  override fun build(generator: MockGenerator) {
    generator.add(
        ProtocolMethod("map", null, "closure: () -> ()", "func map(closure: () -> ())"),
        ProtocolMethod("flatMap", null, "closure: () -> Void", "func flatMap(closure: () -> Void)"),
        ProtocolMethod("filter", null, "closure: (String) -> Bool", "func filter(closure: (String) -> Bool)"),
        ProtocolMethod("multi", null, "animations: (Int) -> (), completion: (Bool) -> ()", "func multi(animations: (Int) -> (), completion: (Bool) -> ())"),
        ProtocolMethod("optional", null, "animations: ((Int) -> ())?, completion: ((Bool) -> ())?", "func optional(animations: ((Int) -> ())?, completion: ((Bool) -> ())?)"),
        ProtocolMethod("optionalParam", null, "_ closure: (String?) -> ()", "func optionalParam(_ closure: (String?) -> ())"),
        ProtocolMethod("optionalParams", null, "_ closure: (String?, Int?) -> ()", "func optionalParams(_ closure: (String?, Int?) -> ())"),
        ProtocolMethod("optionalArrayParams", null, "_ closure: ([String]?, [UInt]) -> ()", "func optionalArrayParams(_ closure: ([String]?, [UInt]) -> ())"),
        ProtocolMethod("doNotSuppressWarning1", null, "_ closure: () -> ()", "func doNotSuppressWarning1(_ closure: () -> ())"),
        ProtocolMethod("doNotSuppressWarning2", null, "_ closure: () -> Void", "func doNotSuppressWarning2(_ closure: () -> Void)"),
        ProtocolMethod("doNotSuppressWarning3", null, "_ closure: () -> (Void)", "func doNotSuppressWarning3(_ closure: () -> (Void))"),
        ProtocolMethod("suppressWarning1", null, "_ closure: () -> String", "func suppressWarning1(_ closure: () -> String)"),
        ProtocolMethod("suppressWarning2", null, "_ closure: () -> (String)", "func suppressWarning2(_ closure: () -> (String))"),
        ProtocolMethod("suppressWarning3", null, "_ closure: () -> String?", "func suppressWarning3(_ closure: () -> String?)"),
        ProtocolMethod("suppressWarning4", null, "_ closure: () -> String!", "func suppressWarning4(_ closure: () -> String!)")
    )
  }

  override fun getExpected(): String {
    return """
    var invokedMap = false
    var invokedMapCount = 0
    func map(closure: () -> ()) {
    invokedMap = true
    invokedMapCount += 1
    closure()
    }
    var invokedFlatMap = false
    var invokedFlatMapCount = 0
    func flatMap(closure: () -> Void) {
    invokedFlatMap = true
    invokedFlatMapCount += 1
    closure()
    }
    var invokedFilter = false
    var invokedFilterCount = 0
    var stubbedFilterClosureResult: (String, Void)?
    func filter(closure: (String) -> Bool) {
    invokedFilter = true
    invokedFilterCount += 1
    if let result = stubbedFilterClosureResult {
    _ = closure(result.0)
    }
    }
    var invokedMulti = false
    var invokedMultiCount = 0
    var stubbedMultiAnimationsResult: (Int, Void)?
    var stubbedMultiCompletionResult: (Bool, Void)?
    func multi(animations: (Int) -> (), completion: (Bool) -> ()) {
    invokedMulti = true
    invokedMultiCount += 1
    if let result = stubbedMultiAnimationsResult {
    animations(result.0)
    }
    if let result = stubbedMultiCompletionResult {
    completion(result.0)
    }
    }
    var invokedOptional = false
    var invokedOptionalCount = 0
    var stubbedOptionalAnimationsResult: (Int, Void)?
    var stubbedOptionalCompletionResult: (Bool, Void)?
    func optional(animations: ((Int) -> ())?, completion: ((Bool) -> ())?) {
    invokedOptional = true
    invokedOptionalCount += 1
    if let result = stubbedOptionalAnimationsResult {
    animations?(result.0)
    }
    if let result = stubbedOptionalCompletionResult {
    completion?(result.0)
    }
    }
    var invokedOptionalParam = false
    var invokedOptionalParamCount = 0
    var stubbedOptionalParamClosureResult: (String?, Void)?
    func optionalParam(_ closure: (String?) -> ()) {
    invokedOptionalParam = true
    invokedOptionalParamCount += 1
    if let result = stubbedOptionalParamClosureResult {
    closure(result.0)
    }
    }
    var invokedOptionalParams = false
    var invokedOptionalParamsCount = 0
    var stubbedOptionalParamsClosureResult: (String?, Int?)?
    func optionalParams(_ closure: (String?, Int?) -> ()) {
    invokedOptionalParams = true
    invokedOptionalParamsCount += 1
    if let result = stubbedOptionalParamsClosureResult {
    closure(result.0, result.1)
    }
    }
    var invokedOptionalArrayParams = false
    var invokedOptionalArrayParamsCount = 0
    var stubbedOptionalArrayParamsClosureResult: ([String]?, [UInt])?
    func optionalArrayParams(_ closure: ([String]?, [UInt]) -> ()) {
    invokedOptionalArrayParams = true
    invokedOptionalArrayParamsCount += 1
    if let result = stubbedOptionalArrayParamsClosureResult {
    closure(result.0, result.1)
    }
    }
    var invokedDoNotSuppressWarning1 = false
    var invokedDoNotSuppressWarning1Count = 0
    func doNotSuppressWarning1(_ closure: () -> ()) {
    invokedDoNotSuppressWarning1 = true
    invokedDoNotSuppressWarning1Count += 1
    closure()
    }
    var invokedDoNotSuppressWarning2 = false
    var invokedDoNotSuppressWarning2Count = 0
    func doNotSuppressWarning2(_ closure: () -> Void) {
    invokedDoNotSuppressWarning2 = true
    invokedDoNotSuppressWarning2Count += 1
    closure()
    }
    var invokedDoNotSuppressWarning3 = false
    var invokedDoNotSuppressWarning3Count = 0
    func doNotSuppressWarning3(_ closure: () -> (Void)) {
    invokedDoNotSuppressWarning3 = true
    invokedDoNotSuppressWarning3Count += 1
    closure()
    }
    var invokedSuppressWarning1 = false
    var invokedSuppressWarning1Count = 0
    func suppressWarning1(_ closure: () -> String) {
    invokedSuppressWarning1 = true
    invokedSuppressWarning1Count += 1
    _ = closure()
    }
    var invokedSuppressWarning2 = false
    var invokedSuppressWarning2Count = 0
    func suppressWarning2(_ closure: () -> (String)) {
    invokedSuppressWarning2 = true
    invokedSuppressWarning2Count += 1
    _ = closure()
    }
    var invokedSuppressWarning3 = false
    var invokedSuppressWarning3Count = 0
    func suppressWarning3(_ closure: () -> String?) {
    invokedSuppressWarning3 = true
    invokedSuppressWarning3Count += 1
    _ = closure()
    }
    var invokedSuppressWarning4 = false
    var invokedSuppressWarning4Count = 0
    func suppressWarning4(_ closure: () -> String!) {
    invokedSuppressWarning4 = true
    invokedSuppressWarning4Count += 1
    _ = closure()
    }
    """.trimIndent()
  }
}
