fun main() {
    println(problem007(10001))
}

fun problem007(n: Int): Long {
    var lastPrimeIndex = 2
    var candidate = 3L

    while (lastPrimeIndex < n) {
        candidate += 2L

        if (isPrime(candidate)) {
            lastPrimeIndex += 1
        }
    }
    return candidate
}