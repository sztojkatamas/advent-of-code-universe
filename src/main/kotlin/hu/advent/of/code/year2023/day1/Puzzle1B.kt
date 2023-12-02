package hu.advent.of.code.year2023.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2023) {

    private val replacements = mapOf(
        "one" to "o1e",
        "two" to "t2o",
        "three" to "t3e",
        "four" to "f4r",
        "five" to "f5e",
        "six" to "s6x",
        "seven" to "s7n",
        "eight" to "e8t",
        "nine" to "n9e"
    )

    override fun run() {
        printPuzzleName()
        var sum = 0
        loadDataFromFile("data1.txt")

        data.forEach {
            var line = it

            for ((word, num) in replacements) {
                line = line.replace(word,num)
            }
            val numbers = line.replace(Regex("[^0-9]"), "")
            val addition = "${numbers.first()}${numbers.last()}".toInt()
            sum += addition
        }

        println("The sum of all of the (spelled out) calibration values: $sum")

    }
}