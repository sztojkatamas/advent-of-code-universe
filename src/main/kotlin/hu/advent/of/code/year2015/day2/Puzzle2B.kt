package hu.advent.of.code.year2015.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2B: BaseChallenge(2015) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        var sumOfRibbonNeeded = 0L

        data.forEach(fun(s: String) {
            sumOfRibbonNeeded += PresentBox(s).ribbon()
        })
        println("$sumOfRibbonNeeded feet of ribbon needed")
    }
}