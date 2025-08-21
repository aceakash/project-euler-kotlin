package common

import io.github.oshai.kotlinlogging.KotlinLogging
import java.lang.Math.floorDiv

private val logger = KotlinLogging.logger {}

fun benchmark(name: String, block: () -> Unit) {
    println("Running benchmark for $name ...")
    logger.info { "Running benchmark for $name ..." }

    // warmup and calibrate
    var startTime = System.nanoTime()
    val calibrateIterationCount = 2
    logger.debug { "Calibrating benchmark with $calibrateIterationCount iterations..." }
    for (i in 1..calibrateIterationCount) {
        block()
    }
    var endTime = System.nanoTime()
    val meanTimeNs = (endTime - startTime) / calibrateIterationCount
    logger.debug { "...calibration complete. Mean time per iteration: $meanTimeNs ns" }


    val targetBenchmarkTimeNs = 10 * 1_000_000_000L
    var remainingBenchmarkTimeNs = targetBenchmarkTimeNs - (endTime - startTime)
    if (remainingBenchmarkTimeNs <= 0) {
        remainingBenchmarkTimeNs = targetBenchmarkTimeNs
    }

    val iterations = floorDiv(remainingBenchmarkTimeNs, meanTimeNs)

    logger.debug { "Running benchmark for $name with $iterations iterations, should take ${remainingBenchmarkTimeNs/1_000_000_000} sec..." }
    startTime = System.nanoTime()
    for (i in 1..iterations) {
        block()
    }
    endTime = System.nanoTime()

    val duration = ((endTime - startTime))
    val meanDurationNs = duration / iterations

    // format with commas
    val meanDurationNsFormatted = "%,d".format(meanDurationNs)
    logger.info { "... benchmark finished. Ran $iterations times at a mean of $meanDurationNsFormatted ns per iteration" }

}