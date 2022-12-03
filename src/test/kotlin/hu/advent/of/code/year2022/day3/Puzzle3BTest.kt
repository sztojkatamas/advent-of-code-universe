package hu.advent.of.code.year2022.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle3BTest {
    @Test
    fun `find the badge of the elf group`() {

        val puzzle = Puzzle3B()
        assertEquals(18, puzzle.findBadge(
            listOf(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg")))

        assertEquals(52, puzzle.findBadge(
            listOf(
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw")))
    }
}