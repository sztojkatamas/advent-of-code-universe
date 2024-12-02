package hu.advent.of.code.year2024.day2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class Puzzle2BTest {
    val data = mutableListOf(
        "7 6 4 2 1",
        "1 2 7 8 9",
        "9 7 6 2 1",
        "1 3 2 4 5",
        "8 6 4 4 1",
        "1 3 6 7 9"
    )

    @Test
    fun `Tolerated safe report tests`() {
        val puzzle = Puzzle2B()
        puzzle.data = data
        assertTrue(puzzle.isReportSafeWithTolerance(data[0]))
        assertFalse(puzzle.isReportSafeWithTolerance(data[1]))
        assertFalse(puzzle.isReportSafeWithTolerance(data[2]))
        assertTrue(puzzle.isReportSafeWithTolerance(data[3]))
        assertTrue(puzzle.isReportSafeWithTolerance(data[4]))
        assertTrue(puzzle.isReportSafeWithTolerance(data[5]))
    }
}