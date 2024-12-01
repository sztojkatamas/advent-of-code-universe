package hu.advent.of.code.year2024.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import kotlin.math.abs

@AdventOfCodePuzzle
class Puzzle1A: BaseChallenge(2024) {

    var left = mutableListOf<Int>()
    var right = mutableListOf<Int>()

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        makeSortedListsFromData()
        println("Total difference is: ${calculateTotalDistance()}")
    }

    fun makeSortedListsFromData() {
        data.forEach {
            val xxx = it.split("   ")
            left.add(xxx[0].toInt())
            right.add(xxx[1].toInt())
        }
        left.sort()
        right.sort()
    }

    fun calculateTotalDistance(): Int {
        var totalDiff = 0
        repeat(left.size) {

            totalDiff += abs(right[it] - left[it])
        }
        return totalDiff
    }
}