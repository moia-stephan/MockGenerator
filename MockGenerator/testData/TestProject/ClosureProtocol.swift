import Foundation

typealias Completion = (Int) -> (String)

protocol ClosureProtocol {
    typealias T = (String) -> ()
    func map(closure: () -> ())
    func flatMap(closure: () -> Void)
    func filter(closure: (String) -> Bool)
    func typealiasClosure(closure: Completion)
    func internalTypealiasClosure(closure: T)
    func multi(animations: (Int) -> (), completion: (Bool) -> ())
    func optional(animations: ((Int) -> ())?, completion: ((Bool) -> ())?)
    func escaping(closure: @escaping () -> ())
    func inOut(var1: inout Int)
    func autoclosure(closure: @autoclosure () -> ())
    func convention(closure: @convention(swift) () -> ())
    func returnClosure() -> (() -> ())
    func returnClosureArgs() -> (Int, String) -> (String)
    func optionalParam(_ closure: (String?) -> ())
    func optionalParams(_ closure: (String?, Int?) -> ())
    func optionalArrayParams(_ closure: ([String]?, [UInt]) -> ())
    func parse(response data: Data) // should not resolve Data and treat as closure
    func doNotSuppressWarning1(_ closure: () -> ())
    func doNotSuppressWarning2(_ closure: () -> Void)
    func doNotSuppressWarning3(_ closure: () -> (Void))
    func suppressWarning1(_ closure: () -> String)
    func suppressWarning2(_ closure: () -> (String))
    func suppressWarning3(_ closure: () -> String?)
    func suppressWarning4(_ closure: () -> String!)
}
