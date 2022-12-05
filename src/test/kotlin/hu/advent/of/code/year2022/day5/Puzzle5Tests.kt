package hu.advent.of.code.year2022.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle5Tests {

    @Test
    fun `test CrateMover 9000`() {
        val data = mutableListOf(
            "    [D]",
            "[N] [C]",
            "[Z] [M] [P]",
            " 1   2   3 ",
            "",
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2"
        )
        val head = CrateMover.getHeader(data)
        val moves = CrateMover.getMoves(data)
        val numberOfStacks = CrateMover.getNumberOfStacks(head.last())
        val stacksx = CrateMover.initStacks(numberOfStacks)
        stacksx.populateStacks(head, numberOfStacks)
        stacksx.moveCrates9000(moves)
        assertEquals("CMZ", CrateMover.getTopCrates(numberOfStacks, stacksx))
    }
    @Test
    fun `test CrateMover 9001`() {
        val data = mutableListOf(
            "    [D]",
            "[N] [C]",
            "[Z] [M] [P]",
            " 1   2   3 ",
            "",
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2"
        )
        val head = CrateMover.getHeader(data)
        val moves = CrateMover.getMoves(data)
        val numberOfStacks = CrateMover.getNumberOfStacks(head.last())
        val stacksx = CrateMover.initStacks(numberOfStacks)
        stacksx.populateStacks(head, numberOfStacks)
        stacksx.moveCrates9001(moves)
        assertEquals("MCD", CrateMover.getTopCrates(numberOfStacks, stacksx))

    }
}