package hu.advent.of.code.year2018.day5

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle5B: BaseChallenge(2018) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("input5.txt")
        val polymer = data[0]
        var min = data[0].length
        for (i in 65..90) {
            val badUnit = i.toChar().toString()
            val m = Polymer.reduce(Polymer.strip(badUnit, polymer)).length
            min = if (min < m) min else m
        }
        println("Shortest polymer length: $min")
    }
}