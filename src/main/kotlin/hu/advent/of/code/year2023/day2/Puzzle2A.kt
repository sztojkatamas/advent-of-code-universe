package hu.advent.of.code.year2023.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2A: BaseChallenge(2023) {
    private val RED_MAX = 12
    private val GREEN_MAX = 13
    private val BLUE_MAX = 14

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        var sum = 0
        data.forEach {
            if(checkSets(it.split(": ")[1].split("; "))) {
                sum += it.split(" ", ":")[1].trim().toInt()
            }
        }
        println("The sum of game IDs: $sum")
    }

    private fun checkSets(sets: List<String>) : Boolean {
        sets.forEach {
            val set = it.split(", ")
            set.forEach { pairString ->
                val pair = pairString.split(" ")
                if (!limitValidation(pair)) {
                    return false
                }
            }
        }
        return true
    }

    private fun limitValidation(pair: List<String>): Boolean {
        return when (pair[1]) {
            "green" -> pair[0].trim().toInt() <= GREEN_MAX
            "blue" -> pair[0].trim().toInt() <= BLUE_MAX
            else -> pair[0].trim().toInt() <= RED_MAX
        }
    }
}
