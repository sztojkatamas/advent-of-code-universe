package hu.advent.of.code.year2021.day3

import hu.advent.of.code.year2021.day3.Puzzle3A
import hu.advent.of.code.year2021.day3.bin2int
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle3ATest {

    @Test
    fun `Calculate Power Consumption`() {
        val data = mutableListOf("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010")
        val testClass = Puzzle3A()
        assertEquals(198, testClass.calculatePowerConsumption(data))
    }

    @Test
    fun `Bin to Integer`() {
        //val testClass = Puzzle3A()
        assertEquals(985674, "11110000101001001010".bin2int())
    }

}
