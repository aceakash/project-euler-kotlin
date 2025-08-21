package p004

import common.benchmark

fun main() {
    println(problem004(100, 999)) // Output: 906609
    println(problem004_optimised(100, 999))
    println(problem004_functional(100, 999))

    benchmark("problem004") { problem004(100, 999) }
    benchmark("problem004_functional", { problem004_functional(100, 999) })
    benchmark("problem004_optimised", { problem004_optimised(100, 999) })
}

fun isPalindrome(num: Int): Boolean {
    return num.toString() == num.toString().reversed()
}

fun problem004(min: Int, max: Int): Int {
    var largest = 0
    for (i in min..max) {
        for (j in min..max) {
            val prod = i * j
            if (isPalindrome(i * j) && prod > largest) {
                largest = prod
            }
        }
    }
    return largest
}

fun problem004_functional(min: Int, max: Int): Int {
    return (min..max)
        .map { i -> (i..max).map { j -> i * j } } // not readable
        .flatten()
        .filter { isPalindrome(it) }
        .maxOrNull() ?: 0
}

fun problem004_optimised(min: Int, max: Int): Int {
    var largest = 0
    for (i in (max) downTo min) {
        for (j in max downTo min) {
            val prod = i * j
            if (prod <= largest) break
            if (isPalindrome(i * j)) {
                largest = prod
            }
        }
    }
    return largest
}






