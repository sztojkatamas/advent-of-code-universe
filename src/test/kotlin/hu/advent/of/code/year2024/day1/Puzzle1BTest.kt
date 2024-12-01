package hu.advent.of.code.year2024.day1

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Puzzle1BTest {
    val data = mutableListOf(
        "3   4",
        "4   3",
        "2   5",
        "1   3",
        "3   9",
        "3   3"
    )

    @Test
    fun `Similarity calculator`() {
        val puzzle = Puzzle1B()
        puzzle.data = data
        puzzle.makeListsFromData()
        assertEquals(31L, puzzle.calculateSimilarityScore())
    }
}