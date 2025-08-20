package common

import java.lang.Math.floorDiv

fun benchmark(name: String, block: () -> Unit) {
    println("Running benchmark for $name ...")

    // warmup and calibrate

    var startTime = System.nanoTime()
    val calibrateIterationCount = 2
    for (i in 1..calibrateIterationCount) {
        block()
    }
    var endTime = System.nanoTime()
    val meanTimeNs = (endTime - startTime) / calibrateIterationCount

    val targetBenchmarkTimeNs = 10 * 1_000_000_000L
    var remainingBenchmarkTimeNs = targetBenchmarkTimeNs - (endTime - startTime)
    if (remainingBenchmarkTimeNs <= 0) {
        remainingBenchmarkTimeNs = targetBenchmarkTimeNs
    }

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
    println("... benchmark finished. Ran $iterations times at a mean of $meanDurationNsFormatted ns per iteration")

}