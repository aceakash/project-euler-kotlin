package common

class Grid<T>(
    raw: String,
    private val parseElement: (String) -> T = { it as T }
) {

    private val tokens: List<List<String>> = raw
        .trimIndent()
        .lines()
        .filter { it.isNotBlank() }
        .map { it.trim().split(Regex("\\s+")) }
        .also { rows ->
            if (rows.isNotEmpty()) {
                val w = rows.first().size
                require(rows.all { it.size == w }) { "Inconsistent row widths detected." }
            }
        }

    val height: Int = tokens.size
    val width: Int = tokens.firstOrNull()?.size ?: 0

    fun elementAt(x: Int, y: Int): T {
        require(y in 0 until height) { "Row index $y out of bounds (0 until $height)." }
        require(x in 0 until width) { "Column index $x out of bounds (0 until $width)." }
        val token = tokens[y][x]
        return parseElement(token)
    }

    fun getRows(): List<List<T>> {
        return tokens.map { row -> row.map { parseElement(it) } }
    }
}

