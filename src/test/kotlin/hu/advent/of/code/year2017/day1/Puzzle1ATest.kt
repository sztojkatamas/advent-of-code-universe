package hu.advent.of.code.year2017.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle1ATest {

    @Test
    fun testCapcha() {
        val puzzle = Puzzle1A()
        assertEquals(3, puzzle.captchaSolver("1122"))
        assertEquals(4, puzzle.captchaSolver("1111"))
        assertEquals(0, puzzle.captchaSolver("1234"))
        assertEquals(9, puzzle.captchaSolver("91212129"))
    }
}