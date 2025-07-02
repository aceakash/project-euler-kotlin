import kotlin.system.measureTimeMillis

fun main() {
    println("Benchmarking isPrime function...")
    benchmark_isPrime()
    println("\nBenchmarking isPrime_v2 function...")
}

fun benchmark_isPrime() {
    // A large prime number to make the test take a meaningful amount of time.
    val largePrime = 1_000_000_007L
    // A large composite number with small factors.
    val largeComposite = 1_000_000_009L // (7 * 11 * 13 * 999991)

    // --- WARM-UP PHASE ---
    // Run the code a few times to allow the JIT compiler to optimize it.
    println("Warming up the JVM...")
    repeat(10_000) {
        isPrime(largePrime)
        isPrime(largeComposite)
    }
    println("Warm-up complete.")

    // --- BENCHMARKING PHASE ---
    println("\nStarting benchmarks...")
    val primeTime = measureTimeMillis {
        repeat(100_000) {
            isPrime(largePrime)
        }
    }
    println("Checking a large prime 100,000 times took: $primeTime ms")

    val compositeTime = measureTimeMillis {
        repeat(100_000) {
            isPrime(largeComposite)
        }
    }
    println("Checking a large composite 100,000 times took: $compositeTime ms")
}
