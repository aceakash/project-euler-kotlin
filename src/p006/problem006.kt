package p006

import common.benchmark

fun main() {
    println(problem006(100)) // Output: 25164150

//    benchmark("problem006", { problem006(100) })
}

fun problem006(upto: Int): Int {
    val sumOfSquares = (1..upto).map { it * it }.sum()
    val sum = (1..upto).sum()
    val squareOfSum = sum * sum

    return squareOfSum - sumOfSquares
}