import kotlin.math.sqrt

fun main() {
    println(problem003(41))
    println(problem003(600851475143))
    benchmarkProblem003(600851475143)

    println(problem003_v2(13195))
    println(problem003_v2(600851475143))
    benchmarkProblem003_v2(600851475143)


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

fun benchmarkProblem003(num: Long): Unit {
    // warmup
    for (i in 1..1000) {
        problem003(num)
    }

    // benchmark
    val times = 1000
    val startTime = System.nanoTime()
    for (i in 1..times) {
        problem003(num)
    }

    val endTime = System.nanoTime()
    val duration = ((endTime - startTime)) / 1_000_000 // convert to ms
    println("problem003($num), running $times times, took: $duration ms")
}

fun benchmarkProblem003_v2(num: Long): Unit {
    // warmup
    for (i in 1..1000) {
        problem003_v2(num)
    }

    // benchmark
    val times = 1000
    val startTime = System.nanoTime()
    for (i in 1..times) {
        problem003_v2(num)
    }

    val endTime = System.nanoTime()
    val duration = ((endTime - startTime)) / 1_000_000 // convert to ms
    println("problem003_v2($num), running $times times, took: $duration ms")
}


