package hu.advent.of.code.year2022.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle3ATest {

    @Test
    fun rucksackPriorityTest() {

        val puzzle = Puzzle3A()
        assertEquals(16, puzzle.rucksackPriority("vJrwpWtwJgWrhcsFMMfFFhFp"))
        assertEquals(38, puzzle.rucksackPriority("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"))
        assertEquals(42, puzzle.rucksackPriority("PmmdzqPrVvPwwTWBwg"))
        assertEquals(22, puzzle.rucksackPriority("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"))
        assertEquals(20, puzzle.rucksackPriority("ttgJtRGJQctTZtZT"))
        assertEquals(19, puzzle.rucksackPriority("CrZsJsPPZsGzwwsLwLmpwMDw"))
    }
}