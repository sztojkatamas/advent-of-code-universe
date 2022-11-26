package hu.advent.of.code.year2021.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge


@AdventOfCodePuzzle
class Puzzle1A: BaseChallenge(2021) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")

        println("Depth count = ${countDepth(data)}")
    }

    fun countDepth(depthdata: MutableList<String>) : Int {

        var previous = depthdata[0].toInt()
        var depthCounter = 0
        for (i in depthdata) {
            if (previous < i.toInt()) {
                depthCounter++
            }
            previous = i.toInt()
        }
        return depthCounter
    }
}