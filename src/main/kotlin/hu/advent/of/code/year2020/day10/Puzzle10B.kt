package hu.advent.of.code.year2020.day10

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle10B : BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        val baseData = loadIntDataFromFile("data10.txt").toMutableList()

        baseData.add(0)
        baseData.add(baseData.maxOrNull()!! + 3)

        val distanceList = makeDistanceList(baseData.sorted())
        var sum = 1L
        var lengthOfBlockOfOnes = 0

        for (i in distanceList.indices) {
            when (distanceList[i]) {
                1 -> {
                    lengthOfBlockOfOnes ++
                }
                3 -> {
                    if (lengthOfBlockOfOnes > 1) {
                        sum *= ways(lengthOfBlockOfOnes)
                    }
                    lengthOfBlockOfOnes = 0
                }
            }
        }
        println("The total number of distinct ways are: $sum")
    }

    private fun ways(len :Int) :Long{
        return when(len) {
            1 -> {1}
            2 -> {2}
            3 -> {4}
            4 -> {7}
            5 -> {13}
            6 -> {22}
            else -> 0
        }
    }
}