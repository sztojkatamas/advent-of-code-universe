package hu.advent.of.code.year2019.day1

import hu.advent.of.code.year2019.day1.Puzzle1A
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Puzzle1ATest {

    @Test
    fun testFuelCalculator() {
        val puzzle = Puzzle1A()
        assertEquals(puzzle.calculateFuelForMass(12), 2)
        assertEquals(puzzle.calculateFuelForMass(14), 2)
        assertEquals(puzzle.calculateFuelForMass(1969), 654)
        assertEquals(puzzle.calculateFuelForMass(100756), 33583)
    }
}


