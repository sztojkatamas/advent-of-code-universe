package hu.advent.of.code.year2021.day3

import hu.advent.of.code.year2021.day3.Puzzle3B
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle3BTest {

    @Test
    fun `Calculate O2 Generator Rating`() {
        val data = mutableListOf("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")
        val testClass = Puzzle3B()
        assertEquals(23, testClass.calculateOxigenGeneratorRating(data, 0))
    }

    @Test
    fun `Calculate CO2 Scrubber Rating`() {
        val data = mutableListOf("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")
        val testClass = Puzzle3B()
        assertEquals(10, testClass.calculateCO2ScrubberRating(data, 0))
    }
}