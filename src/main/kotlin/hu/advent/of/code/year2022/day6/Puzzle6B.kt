package hu.advent.of.code.year2022.day6

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle6B: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data6.txt")
        println("Message marker is at place ${data[0].findMarker(14)}")
    }
}
