package hu.advent.of.code.year2024.day2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Puzzle2ATest {
    val data = mutableListOf(
        "7 6 4 2 1",
        "1 2 7 8 9",
        "9 7 6 2 1",
        "1 3 2 4 5",
        "8 6 4 4 1",
        "1 3 6 7 9"
    )

    @Test
    fun `Safe report tests`() {
        val puzzle = Puzzle2A()
        puzzle.data = data
        assertTrue(puzzle.isReportSafe(data[0]))
        assertFalse(puzzle.isReportSafe(data[1]))
        assertFalse(puzzle.isReportSafe(data[2]))
        assertFalse(puzzle.isReportSafe(data[3]))
        assertFalse(puzzle.isReportSafe(data[4]))
        assertTrue(puzzle.isReportSafe(data[5]))
    }
}