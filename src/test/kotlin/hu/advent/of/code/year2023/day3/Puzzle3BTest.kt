package hu.advent.of.code.year2023.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Puzzle3BTest {
    val data = mutableListOf(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...${'$'}.*....",
        ".664.598.."
    )

    @Test
    fun `Gear ratio test`() {
        val puzzle = Puzzle3B()
        puzzle.data = data
        val number = puzzle.gatherGearRatios()
        Assertions.assertEquals(467835, number.sum())
    }
}