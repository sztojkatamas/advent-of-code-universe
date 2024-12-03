package hu.advent.of.code.year2024.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle3B: BaseChallenge(2024) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")

        var sum = 0L
        var enabled = true
        val regex = Regex("""(do\(\)|don't\(\)|mul\((\d{1,3}),(\d{1,3})\))""")

        data.forEach { line ->
            val matches = regex.findAll(line).map { it.value }.toList()

            matches.forEach {
                enabled = when (it) {
                    "do()" -> true
                    "don't()" -> false
                    else -> enabled // :)
                }

                if(enabled && it.startsWith("mul")) {
                    val o = it.split("(", ",", ")")
                    sum+= o[1].toInt() * o[2].toInt()
                }
            }
        }
        println("The sum of the 'enabled' multiplications: $sum")

    }

}