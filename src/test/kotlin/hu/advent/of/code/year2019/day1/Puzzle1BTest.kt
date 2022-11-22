package hu.advent.of.code.year2019.day1

import hu.advent.of.code.year2019.day1.Puzzle1B
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Puzzle1BTest {

    @Test
    fun testFuelCalculator() {
        val puzzle = Puzzle1B()
        assertEquals(puzzle.calculateFuelForTotalMassWithFuel(14), 2)
        assertEquals(puzzle.calculateFuelForTotalMassWithFuel(1969), 966)
        assertEquals(puzzle.calculateFuelForTotalMassWithFuel(100756), 50346)
    }
}