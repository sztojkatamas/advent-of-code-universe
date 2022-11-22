package hu.advent.of.code.year2015.day5

import hu.advent.of.code.year2015.day5.Puzzle5A
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Puzzle5ATest {

    @Test
    fun testIsNice() {
        val puzzle = Puzzle5A()
        assertTrue(puzzle.isNice("ugknbfddgicrmopn"))
        assertTrue(puzzle.isNice("aaa"))
        assertTrue(puzzle.isNice("fwrfewfaaa"))
        assertTrue(puzzle.isNice("fwrfewfaaeefwefwef"))
        assertTrue(puzzle.isNice("qwertrrukji"))
    }

    @Test
    fun testIsNaughty() {
        val puzzle = Puzzle5A()
        assertFalse(puzzle.isNice("jchzalrnumimnmhp"))
        assertFalse(puzzle.isNice("haegwjzuvuyypxyu"))
        assertFalse(puzzle.isNice("dvszwmarrgswjxmb"))
    }

    @Test
    fun testDoubles() {
        val puzzle = Puzzle5A()
        assertFalse(puzzle.hasDoubles("g"))
        assertFalse(puzzle.hasDoubles("gw"))
        assertTrue(puzzle.hasDoubles("ee"))
        assertTrue(puzzle.hasDoubles("uenbfiwfbewiufbGG"))
        assertTrue(puzzle.hasDoubles("uenbfiyywfbewiufb"))
        assertFalse(puzzle.hasDoubles("uenbfiwfbewiufb"))

    }
}