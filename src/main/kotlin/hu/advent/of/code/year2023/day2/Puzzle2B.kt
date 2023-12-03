package hu.advent.of.code.year2023.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2B: BaseChallenge(2023) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        var sum = 0L

        data.forEach { line ->
            val greens = mutableListOf<Int>()
            val blues = mutableListOf<Int>()
            val reds = mutableListOf<Int>()

            val sets = line.split(": ")[1].split("; ")
            sets.forEach { pairString ->
                val pairs = pairString.split(", ")
                pairs.forEach {
                    val pair = it.split(" ")
                    val number = pair[0].trim().toInt()
                    when (pair[1]) {
                        "green" -> greens.add(number)
                        "blue" -> blues.add(number)
                        else -> reds.add(number)
                    }
                }
            }
            sum += greens.max() * blues.max() * reds.max()
        }
        println("The sum of the power of the sets is: $sum")
    }
}