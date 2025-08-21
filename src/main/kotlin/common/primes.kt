package common

import kotlin.math.sqrt

var knownPrimes = mutableSetOf<Long>(2)


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


fun getPrimeFactors(num: Long): List<Long> {
    if (num < 2) return emptyList()

    if (num in knownPrimes) {
        return listOf(num)
    }

    if (num == 3L) {
        knownPrimes.add(3)
        return listOf(3)
    }
    val upto = sqrt(num.toDouble()).toLong() + 1
    for (i in 2L .. upto) {
        if (num % i == 0L) {
            return getPrimeFactors(i) + getPrimeFactors(num/i)
        }
    }
    knownPrimes.add(num)
    return listOf(num)
}

