package common

import kotlin.test.Test
import com.natpryce.hamkrest.assertion.*
import com.natpryce.hamkrest.*


class GridTest {
    @Test
    fun `creating a grid from a string in tabular form`() {
        val grid = Grid<Int>("""
            08 02 22 97 38
            49 49 99 40 17
            81 49 31 73 55
            52 70 95 23 04
            22 31 16 71 51
        """.trimIndent(), String::toInt)

        assertThat(grid.elementAt(0,0), equalTo(8))
        assertThat(grid.elementAt(0,1), equalTo(49))
        assertThat(grid.elementAt(1,0), equalTo(2))
        assertThat(grid.elementAt(4,4), equalTo(51))

    }

    @Test
    fun `get rows`() {
        val grid = Grid<Int>("""
            01 02 03
            04 05 06
            07 08 09
        """.trimIndent(), String::toInt)

        assertThat(grid.getRows(), equalTo(listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9),
        )))
    }


}