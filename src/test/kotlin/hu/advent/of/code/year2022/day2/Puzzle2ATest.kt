package hu.advent.of.code.year2022.day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle2ATest {

    @Test
    fun gameTest() {
        val puzzle = Puzzle2A()
        assertEquals(15,
            puzzle.getGameOutcome("A Y")
                + puzzle.getGameOutcome("B X")
                + puzzle.getGameOutcome("C Z"))
    }
}