package p005

import common.benchmark
import common.getPrimeFactors
import kotlin.collections.toMutableList

fun main() {
    println(problem005(1, 20))
    println(problem005_v2(1, 20))

    benchmark("problem005", { problem005(1, 20) })
    benchmark("problem005_v2", { problem005_v2(1, 20) })
}

fun problem005(from: Int, to: Int): Int {
    var multiple = 1
    while (true) {
        val candidate = to * multiple
        if (isDivisibleByAll(candidate, (1..(to-1)).toList())) {
            return candidate
        }
        multiple += 1
    }
}

fun problem005_v2(from: Int, to: Int): Int {
    var answer = from
    for (i in (from+1)..to) {
//        println("Calculating LCM of $answer and $i")
        answer = leastCommonMultiple(answer, i)
//        println("New answer: $answer")

    }
    return answer
}

fun leastCommonMultiple(num1: Int, num2: Int): Int {


    val primeFactors1 = getPrimeFactors(num1.toLong())
//    println("Prime factors of $num1: $primeFactors1")
    val primeFactors2 = getPrimeFactors(num2.toLong())
//    println("Prime factors of $num2: $primeFactors2")
    val commonFactors = intersect(primeFactors1, primeFactors2)
//    println("Common factors: $commonFactors")

    if (commonFactors.isEmpty()) {
        return num1 * num2 // if no common factors, return product
    }

    val prod = commonFactors.reduce { acc, factor ->
        acc * factor
    }
//    println("Product of common factors: $prod")

    return ((num1.toLong() * num2.toLong()) / prod.toLong()).toInt()
}

fun isDivisibleByAll(candidate: Int, nums: List<Int>): Boolean {
    for (num in nums) {
        if (num == 0 || candidate % num != 0) {
            return false
        }
    }
    return true
}

fun intersect(a: List<Long>, b: List<Long>): List<Long> {
    val mutableB = b.toMutableList()
    val intersection = mutableListOf<Long>()

    for (item in a) {
        if (mutableB.contains(item)) {
            intersection.add(item)
            mutableB.remove(item) // remove to avoid duplicates
        }
    }
    return intersection
}