package p003

import common.isPrime
import common.benchmark
import kotlin.math.sqrt

fun main() {
    println(problem003(600851475143)) // Output: 6857
    benchmark("problem003", { problem003(600851475143) })

    println(problem003_v2(600851475143))
    benchmark("problem003_v2", { problem003_v2(600851475143) })
}

fun problem003(num: Long): Long {
    for (i in sqrt(num.toDouble()).toLong() downTo 2) {
        if (num % i == 0L && isPrime(i)) {
            return i
        }
    }
    return num
}

fun problem003_v2(num: Long): Long {

    val factors = mutableListOf(1L)
    var remaining = num


    // divide by 2 until it's odd
    while (remaining % 2 == 0L) {
        factors += 2
        remaining /= 2
    }

    for (i in 3..(sqrt(remaining.toDouble()).toLong() + 1) step 2) {
        if (isPrime(remaining)) {
            factors += remaining
            break
        }

        if (isPrime(i)) {
            while (remaining % i == 0L) {
                factors += i
                remaining /= i
            }
        }
    }

    return remaining
}





