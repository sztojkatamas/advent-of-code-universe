package hu.advent.of.code.year2017.day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle1BTest {

    @Test
    fun advancedCaptchaTest() {

        val puzzle = Puzzle1B()
        assertEquals(6, puzzle.advancedCaptchaSolver("1212"))
        assertEquals(0, puzzle.advancedCaptchaSolver("1221"))
        assertEquals(4, puzzle.advancedCaptchaSolver("123425"))
        assertEquals(12, puzzle.advancedCaptchaSolver("123123"))
        assertEquals(4, puzzle.advancedCaptchaSolver("12131415"))
    }
}