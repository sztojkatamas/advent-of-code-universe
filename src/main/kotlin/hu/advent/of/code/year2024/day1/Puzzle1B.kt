package hu.advent.of.code.year2024.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2024) {

    var left = mutableListOf<Int>()
    var right = mutableListOf<Int>()

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        makeListsFromData()
        println("The similarity score is: ${calculateSimilarityScore()}")
    }
    fun makeListsFromData() {
        data.forEach {
            val xxx = it.split("   ")
            left.add(xxx[0].toInt())
            right.add(xxx[1].toInt())
        }
    }

    fun calculateSimilarityScore(): Long {
        var similarityScore = 0L
        repeat(left.size)  { lineNum ->
            similarityScore += left[lineNum] * right.filter { it == left[lineNum] }.size
        }

        return similarityScore
    }
}