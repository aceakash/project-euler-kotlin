package common

import java.lang.Math.floorDiv

fun benchmark(name: String, block: () -> Unit) {
    println("Running benchmark for $name ...")

    // warmup
    block()

    // calibrate

    var startTime = System.nanoTime()
    val calibrateIterationCount = 2
    for (i in 1..calibrateIterationCount) {
        block()
    }
    var endTime = System.nanoTime()
    val meanTimeNs = (endTime - startTime) / calibrateIterationCount
    println("Warmup complete. Mean time per iteration: $meanTimeNs ns")

    val targetBenchmarkTimeNs = 10 * 1_000_000_000L
    val remainingBenchmarkTimeNs = targetBenchmarkTimeNs - (endTime - startTime)
    println("remainingBenchmarkTimeNs: $remainingBenchmarkTimeNs ns")

    val iterations = floorDiv(remainingBenchmarkTimeNs, meanTimeNs)

    startTime = System.nanoTime()
    for (i in 1..iterations) {
        block()
    }
    endTime = System.nanoTime()

    val duration = ((endTime - startTime))
    val meanDurationNs = duration / iterations

    // format with commas
    val meanDurationNsFormatted = "%,d".format(meanDurationNs)

        println("Benchmark finished. Ran $iterations times at a mean of $meanDurationNsFormatted ns per iteration")

}