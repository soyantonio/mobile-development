import UIKit

// Functions
func arith(a: Int, b: Int, operation: (Int, Int) -> Int) -> Int {
    return operation(a, b)
}

func add(x: Int, y: Int) -> Int {
    return x + y
}

arith(a: 4, b: 5, operation: add)

arith(a: 4, b: 5, operation: {
    (x, y) in x + y
})

let result = arith(a: 9, b: 6, operation: {$0 + $1})



// Protocols : Blue Prints

protocol Identifiable {
    var id: Int {get set}
}

protocol Vaccinated: Identifiable {
    var vaccine: Bool {get set}
}





