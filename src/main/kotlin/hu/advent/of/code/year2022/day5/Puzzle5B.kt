package hu.advent.of.code.year2022.day5

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle5B: BaseChallenge(2022) {
    override fun run() {
        printPuzzleName()
        loadDataFromFile("data5.txt")

        val head = CrateMover.getHeader(data)
        val moves = CrateMover.getMoves(data)
        val numberOfStacks = CrateMover.getNumberOfStacks(head.last())
        val stacks = CrateMover.initStacks(numberOfStacks)
        stacks.populateStacks(head, numberOfStacks)
        stacks.moveCrates9001(moves)
        println("Top crates with CrateMover 9001: ${CrateMover.getTopCrates(numberOfStacks, stacks)}")
    }

}