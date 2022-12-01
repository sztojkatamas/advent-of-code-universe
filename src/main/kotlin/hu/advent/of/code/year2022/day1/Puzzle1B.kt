package hu.advent.of.code.year2022.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        val elves = ElvenUtil.countElvenCalories(data)
        elves.sortByDescending { it.cucc.sum() }
        println("Total calories carried by the top three elves: ${elves.take(3).sumOf { it.cucc.sum() }}")
    }
}