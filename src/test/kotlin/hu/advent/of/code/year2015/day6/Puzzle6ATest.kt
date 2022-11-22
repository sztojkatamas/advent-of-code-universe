package hu.advent.of.code.year2015.day6

import hu.advent.of.code.year2015.day6.Puzzle6A
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class Puzzle6ATest {

    @Test
    fun `Some basic test`() {
        val puzzle6A = Puzzle6A()
        puzzle6A.initLamps(5, 5)

        assertFalse { puzzle6A.getLamp("2-2").working }
        assertFalse { puzzle6A.getLamp("3-2").working }

        puzzle6A.toggleLamp("2-2")
        puzzle6A.switchOnLamp("3-2")
        assertTrue { puzzle6A.getLamp("2-2").working }
        assertEquals(2, puzzle6A.countBrightLamps())

        puzzle6A.switchOffLamp("3-2")
        assertEquals(1, puzzle6A.countBrightLamps())
    }

    @Test
    fun `Range tests`() {
        val puzzle6A = Puzzle6A()
        puzzle6A.initLamps(15, 15)

        puzzle6A.toggleLamps("0-0", "2-2")
        assertEquals(9, puzzle6A.countBrightLamps())

        puzzle6A.switchOnLamps("2-2", "4-0")
        assertEquals(15, puzzle6A.countBrightLamps())

        puzzle6A.switchOffLamps("3-1", "1-1")
        assertEquals(12, puzzle6A.countBrightLamps())

        puzzle6A.toggleLamps("0-0", "4-2")
        assertEquals(3, puzzle6A.countBrightLamps())
    }

}