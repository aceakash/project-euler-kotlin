import kotlin.math.sqrt

fun main() {
    println(problem003(600851475143))
    benchmarkProblem003(600851475143)
}

fun problem003(num: Long): Long {
    for (i in sqrt(num.toDouble()).toLong() downTo 2) {
        if (num % i == 0L && isPrime(i)) {
            return i
        }
    }
    return num
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


