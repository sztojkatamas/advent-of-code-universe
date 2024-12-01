package hu.advent.of.code.year2024.day1

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Puzzle1ATest {
    val data = mutableListOf(
        "3   4",
        "4   3",
        "2   5",
        "1   3",
        "3   9",
        "3   3"
        )

    @Test
    fun `Total difference calculator`() {
        val puzzle = Puzzle1A()
        puzzle.data = data
        puzzle.makeSortedListsFromData()
        assertEquals(1, puzzle.left.first())
        assertEquals(3, puzzle.right.first())
        assertEquals(4, puzzle.left.last())
        assertEquals(9, puzzle.right.last())
        assertEquals(11, puzzle.calculateTotalDistance())
    }
}