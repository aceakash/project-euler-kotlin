package common

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PrimesTest {
    @Test
    fun getPrimeFactors_smallNumbers() {
        assertIterableEquals(listOf(2), getPrimeFactors(2))
        assertIterableEquals(listOf(3), getPrimeFactors(3))
        assertIterableEquals(listOf(2, 2), getPrimeFactors(4))
        assertIterableEquals(listOf(5), getPrimeFactors(5))
        assertIterableEquals(listOf(2, 3), getPrimeFactors(6))
        assertIterableEquals(listOf(7), getPrimeFactors(7))
        assertIterableEquals(listOf(2,2,2), getPrimeFactors(8))
        assertIterableEquals(listOf(3,3), getPrimeFactors(9))
        assertIterableEquals(listOf(2,5), getPrimeFactors(10))
        assertIterableEquals(listOf(11), getPrimeFactors(11))
        assertIterableEquals(listOf(2,2,3), getPrimeFactors(12))
        assertIterableEquals(listOf(13), getPrimeFactors(13))
        assertIterableEquals(listOf(2,7), getPrimeFactors(14))
        assertIterableEquals(listOf(3,5), getPrimeFactors(15))
        assertIterableEquals(listOf(2,2,2,2), getPrimeFactors(16))
        assertIterableEquals(listOf(17), getPrimeFactors(17))
        assertIterableEquals(listOf(2,3,3), getPrimeFactors(18))
        assertIterableEquals(listOf(19), getPrimeFactors(19))
        assertIterableEquals(listOf(2,2,5), getPrimeFactors(20))
        assertIterableEquals(listOf(3,7), getPrimeFactors(21))
        assertIterableEquals(listOf(2,2,2,3), getPrimeFactors(24))
        assertIterableEquals(listOf(5,5), getPrimeFactors(25))
        assertIterableEquals(listOf(2,13), getPrimeFactors(26))
        assertIterableEquals(listOf(3,3,3), getPrimeFactors(27))
        assertIterableEquals(listOf(2,2,7), getPrimeFactors(28))
        assertIterableEquals(listOf(29), getPrimeFactors(29))
        assertIterableEquals(listOf(2,3,5), getPrimeFactors(30))
        assertIterableEquals(listOf(31), getPrimeFactors(31))
        assertIterableEquals(listOf(2,2,2,2,3), getPrimeFactors(48))
        assertIterableEquals(listOf(2,2,2,2,2,3), getPrimeFactors(96))
    }

    @Test
    fun getPrimeFactors_largeNumbers() {
        assertIterableEquals(listOf(2, 3, 5, 7, 11, 13), getPrimeFactors(30030))
        assertIterableEquals(listOf(2, 2, 3, 3, 31, 71, 83), getPrimeFactors(6576588))
    }
}