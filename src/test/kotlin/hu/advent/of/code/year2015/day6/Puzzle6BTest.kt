package hu.advent.of.code.year2015.day6

import hu.advent.of.code.year2015.day6.Puzzle6B
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Puzzle6BTest {

    @Test
    fun `Light levels test`() {
        val puzzle6B = Puzzle6B()
        puzzle6B.initLamps(5,5)
        puzzle6B.processRegion("0-0", "1-1", "on")
        assertEquals(4, puzzle6B.countBrightnessOfTheLamps())

        puzzle6B.processRegion("0-0", "1-1", "off")
        assertEquals(0, puzzle6B.countBrightnessOfTheLamps())

        puzzle6B.processRegion("0-0", "1-1", "toggle")
        assertEquals(8, puzzle6B.countBrightnessOfTheLamps())

    }
}