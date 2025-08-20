package common

import kotlin.math.sqrt


fun isPrime(num: Long): Boolean {
    // Numbers less than 2 are not prime.
    if (num < 2) return false
    // 2 is the only even prime number.
    if (num == 2L) return true
    // All other even numbers are not prime.
    if (num % 2 == 0L) return false

    // Check for odd factors from 3 up to the square root of the number.
    // We can step by 2 because we've already handled all even numbers.
    val limit = sqrt(num.toDouble()).toLong()
    for (i in 3..limit step 2) {
        if (num % i == 0L) {
            return false
        }
    }

    return true
}
