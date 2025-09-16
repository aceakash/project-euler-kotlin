package common

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.math.floor

private val logger = KotlinLogging.logger {}


fun quickSort(nums: Array<Int>): Array<Int> {
    var numCopy = nums.copyOf()

    quickSortRecursive(numCopy)
    return numCopy

}

private fun quickSortRecursive(nums: Array<Int>) {
    if (nums.size < 2) {
        return
    }

    val pivotIndex = floor(nums.size / 2.0).toInt()
    logger.debug { "pivotIndex: $pivotIndex" }

    // every element to the left of the pivot should be smaller
    val leftList = nums.slice(0..pivotIndex - 1)
    val indicesOfElementsToBeMovedRight = getIndexesOfLargerElements(leftList, nums[pivotIndex])

    // every element to the right should be larger
    val rightList = nums.slice(pivotIndex + 1..nums.size - 1)
    val indicesOfElementsToBeMovedLeft = getIndexesOfSmallerElements(rightList, nums[pivotIndex])

    // make new left list
    val newLeftList = mutableListOf<Int>()

    // add current left list except elements that will be moved right
    nums.forEachIndexed { index, i -> if (!indicesOfElementsToBeMovedRight.contains(index)) {
        newLeftList.add(i)
    } }
    logger.debug { "newLeftList is now ${newLeftList.joinToString()}" }

    // add elements that should be moved left
    indicesOfElementsToBeMovedLeft.forEach { i -> newLeftList.add(nums[i]) }
    logger.debug { "newLeftList is ${newLeftList.joinToString()}" }


    // make new right list
    val newRightList = mutableListOf<Int>()


    // add elements that should be moved right
    indicesOfElementsToBeMovedRight.forEach { i -> newLeftList.add(i) }
    logger.debug { "newRightList is now ${newRightList.joinToString()}" }


    // add current right list except elements that will be moved left
    nums.forEachIndexed { index, i -> if (!indicesOfElementsToBeMovedLeft.contains(index)) {
        newRightList.add(i)
    } }
    logger.debug { "newRightList is ${newRightList.joinToString()}" }


    // make new list
    val newList = newLeftList + listOf(nums[pivotIndex]) + newRightList



}

fun getIndexesOfLargerElements(list: List<Int>, pivot: Int): List<Int> {
    return emptyList()
}

fun getIndexesOfSmallerElements(list: List<Int>, pivot: Int): List<Int> {
    return emptyList()
}

fun bubbleSortInPlace(nums: Array<Int>) {
    var upto = nums.size - 2
    while (upto >= 0) {
        for (i in 0 .. upto) {
            if (nums[i] > nums[i+1]) {
                val tmp = nums[i+1]
                nums[i+1] = nums[i]
                nums[i] = tmp
            }
        }
        upto = upto - 1
    }
}

fun insertionSortInPlace(nums: Array<Int>) {
    return
}

fun main() {
    testBubbleSort(arrayOf(7, 29, 15, 36, 24, 20, 18, 30, 12))
    testBubbleSort(arrayOf(98, 97, 96, 95, 94, 98, 95))
}

private fun testBubbleSort(nums: Array<Int>) {
//    println("nums: ${nums.joinToString()}")
    bubbleSortInPlace(nums)
    println("nums, sorted: ${nums.joinToString()}")
}