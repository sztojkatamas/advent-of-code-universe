package hu.advent.of.code.year2018.day5

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle5A: BaseChallenge(2018) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("input5.txt")
        println("Remaining units: ${Polymer.reduce(data[0]).length}")
    }
}