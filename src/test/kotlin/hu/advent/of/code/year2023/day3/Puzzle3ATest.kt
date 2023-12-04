package hu.advent.of.code.year2023.day3

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Puzzle3ATest {
    val data = mutableListOf(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...${'$'}.*....",
        ".664.598.."
        )

    @Test
    fun `Adjacent searcher test`() {
        val puzzle = Puzzle3A()
        puzzle.data = data
        val number = puzzle.gatherNumbers()
        assertEquals(4361, number.sum())
    }
}