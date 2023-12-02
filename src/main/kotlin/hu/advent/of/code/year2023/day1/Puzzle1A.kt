package hu.advent.of.code.year2023.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import hu.advent.of.code.RunOnlyThis

@AdventOfCodePuzzle
@RunOnlyThis
class Puzzle1A: BaseChallenge(2023) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        var sum = 0
        data.forEach {
            val numbers = it.replace(Regex("[^0-9]"), "")
            sum += "${numbers.first()}${numbers.last()}".toInt()
        }

        println("The sum of all of the calibration values: $sum")

    }
}