package hu.advent.of.code.year2022.day8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle8Test {
    @Test
    fun `Tree visibility test`() {
        val data = listOf(
            "30373",
            "25512",
            "65332",
            "33549",
            "35390")
        val rows = data.makeRows()
        val cols = data.makeCols()
        assertEquals(4, rows[3][3])
        assertEquals(9, cols[4][3])
        assertEquals(21, Puzzle8A().countVisibleTrees(rows, cols))
        assertEquals(8, Puzzle8B().getMaxScenicScore(rows, cols))
    }
}
