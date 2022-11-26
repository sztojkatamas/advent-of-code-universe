package hu.advent.of.code.year2021.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2021) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        println("Depth count = ${countDepthTriplet(data.map {it.toInt()})}")
    }

    fun countDepthTriplet(indata: List<Int>) : Int {

        var depthdata = indata
        var previous = depthdata.take(3).sum()
        var depthCounter = 0

        repeat(depthdata.size - 2) {
            val o = depthdata.take(3).sum()
            depthdata = depthdata.drop(1) as MutableList<Int>
            if (previous < o) {
                depthCounter++
            }
            previous = o
        }

        return depthCounter
    }

}