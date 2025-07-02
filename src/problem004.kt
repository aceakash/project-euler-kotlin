fun main() {
    println(problem004())
}

fun problem004(): Int {
    var largest = 1
    for (i in 100..999) {
        for (j in 100..999) {
            val product = i * j
            if (isPalindrome(product) && product > largest) {
                largest = product
            }
        }
    }
    return largest
}

fun isPalindrome(num: Int): Boolean {
    return num.toString().reversed() == num.toString()
}