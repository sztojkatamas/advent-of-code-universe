package hu.advent.of.code.year2017.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle4ATest {

    @Test
    fun testValidPasswords() {
        val puzzle = Puzzle4A()
        assertTrue(puzzle.isLineValid("aa bb cc dd ee"))
        assertTrue(puzzle.isLineValid("aa bb cc dd ee aaa"))
    }

    @Test
    fun testInvalidPasswords() {
        val puzzle = Puzzle4A()
        assertFalse(puzzle.isLineValid("aa bb cc aa ee"))
        assertFalse(puzzle.isLineValid("aa bb cc dd ee cc"))
    }
}