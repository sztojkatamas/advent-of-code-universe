package hu.advent.of.code.year2024.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle3A: BaseChallenge(2024) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")

        var sum = 0L
        val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

        data.forEach { line ->
            val matches = regex.findAll(line).map { it.value }.toList()

            matches.forEach {
                val o = it.split("(", ",", ")")
                sum+= o[1].toInt() * o[2].toInt()
            }
        }
        println("The sum of the multiplications: $sum")

    }

}