package hu.advent.of.code.year2019.day2

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class Puzzle2ATest() {

    @Test
    fun testIntcodeProcessor() {
        assertContentEquals(IntCodeProgramRunner.processCode(intArrayOf(1,0,0,0,99)), intArrayOf(2,0,0,0,99))
        assertContentEquals(IntCodeProgramRunner.processCode(intArrayOf(2,3,0,3,99)), intArrayOf(2,3,0,6,99))
        assertContentEquals(IntCodeProgramRunner.processCode(intArrayOf(2,4,4,5,99,0)), intArrayOf(2,4,4,5,99,9801))
        assertContentEquals(IntCodeProgramRunner.processCode(intArrayOf(1,1,1,4,99,5,6,0,99)), intArrayOf(30,1,1,4,2,5,6,0,99))
    }
}