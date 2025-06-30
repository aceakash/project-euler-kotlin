fun main() {
    println(problem001(3, 5, 1000))
}

fun problem001(num1: Int, num2: Int, below: Int): Int {
    var sum = 0
    for (i in 1..below-1) {
       if (i % num1 == 0 || i % num2 == 0) {
           sum = sum + i
       }
    }
    return sum
}


