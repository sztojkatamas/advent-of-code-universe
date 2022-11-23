package hu.advent.of.code.year2018.day1

import hu.advent.of.code.BaseChallenge

class Puzzle1A: BaseChallenge(2018) {

    override fun run() {
        var sum = 0
        printPuzzleName()
        loadIntDataFromFile("input1.txt").forEach { sum += it }
        println("The resulting frequency: $sum")
    }
}