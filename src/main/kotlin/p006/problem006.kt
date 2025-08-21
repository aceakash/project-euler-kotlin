package p006


fun main() {
    println(problem006(100)) // Output: 25164150
}

fun problem006(upto: Int): Int {
    val sumOfSquares = (1..upto).sumOf { it * it }
    val sum = (1..upto).sum()
    val squareOfSum = sum * sum

    return squareOfSum - sumOfSquares
}