package hu.advent.of.code.year2015.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PresentBoxTest {

    @Test
    fun testWrapping() {
        assertEquals(PresentBox("2x3x4").wrap(), 58)
        assertEquals(PresentBox("1x1x10").wrap(), 43)
    }

    @Test fun testRibbonNeeded() {
        assertEquals(PresentBox("2x3x4").ribbon(), 34)
        assertEquals(PresentBox("1x1x10").ribbon(), 14)
    }

}