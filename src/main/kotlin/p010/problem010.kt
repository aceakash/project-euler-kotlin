package p010

import common.isPrime

fun main() {
    println(problem010(2_000_000)) // Output: 142913828922
}

fun problem010(upto: Int): Long {
   var sum = 0L

    for (i in 2 .. upto-1) {
        if (isPrime(i*1L)) {
            sum += i
        }
    }

   return sum
}