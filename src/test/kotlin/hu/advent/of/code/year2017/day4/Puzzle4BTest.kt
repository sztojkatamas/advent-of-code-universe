package hu.advent.of.code.year2017.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle4BTest {

    @Test
    fun `more advanced password test`() {
        val puzzle = Puzzle4B()
        assertTrue(puzzle.isLineValid("abcde fghij"))
        assertFalse(puzzle.isLineValid("abcde xyz ecdab"))
        assertTrue(puzzle.isLineValid("iiii oiii ooii oooi oooo"))
        assertFalse(puzzle.isLineValid("oiii ioii iioi iiio"))
    }
}