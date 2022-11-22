package hu.advent.of.code.year2015.day4

import hu.advent.of.code.year2015.day4.Puzzle4A
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class Puzzle4ATest {

    @Test
    fun testMD5() {
        val p = Puzzle4A()
        assertTrue(p.goodMD5("abcdef", 609043))
        assertTrue(p.goodMD5("pqrstuv", 1048970))
    }
}