package hu.advent.of.code.year2021.day1

import hu.advent.of.code.year2021.day1.Puzzle1A
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Puzzle1ATest {

    @Test
    fun testTrainingData() {
        val data = mutableListOf<String>("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")
        val testclass = Puzzle1A()
        assertEquals(7, testclass.countDepth(data))
    }
}