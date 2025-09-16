package p009

import common.benchmark
import common.isPrime

fun main() {
    println(problem009(1000)) // Output: ?
}

fun problem009(pythagoreanTripletSum: Int): Long {
   for (a in 1 .. 998) {
       for (b in 1 .. 998) {
           for (c in 1 .. 998) {
               if (a + b + c != pythagoreanTripletSum) {
                   continue
               }
               if (a*a + b*b == c*c) {
                   println("Found $a, $b and $c")
                   return 1L*a*b*c
               }
           }
       }
   }

   return 1L
}