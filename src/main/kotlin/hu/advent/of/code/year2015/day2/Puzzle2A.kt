package hu.advent.of.code.year2015.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2A: BaseChallenge(2015) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        var sumOfWrapPaperNeeded = 0
        data.forEach(fun(s: String) {
            sumOfWrapPaperNeeded += PresentBox(s).wrap()
        })
        println("$sumOfWrapPaperNeeded square feet of paper needed")
    }
}