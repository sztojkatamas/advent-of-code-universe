package hu.advent.of.code.year2022.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1A: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        val elves = ElvenUtil.countElvenCalories(data)
        println("Max calories carried: ${elves.maxBy { it.cucc.sum() }.cucc.sum()}")
    }
}