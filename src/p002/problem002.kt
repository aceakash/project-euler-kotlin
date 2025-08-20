package p002

fun main() {
    println(problem002(4_000_000)) // Output: 4613732
}

fun problem002(below: Int): Long {
    // 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
    // sum of 1, 2, 3, 5, 8 =
    var prev = 2
    var value = 3

    var sum = 2L
    while (value < below) {
        if (value % 2 == 0) {
            sum += value
        }

        // Calculate the next Fibonacci number
        val next = prev + value
        prev = value
        value = next
    }
    return sum
}


