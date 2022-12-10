package hu.advent.of.code.year2022.day10

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle10A: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data10.txt")

        val cycles = mutableListOf<Int>()
        var register = 1
        data.forEach {
            when (it) {
                "noop" -> {
                    cycles.add(register)
                }
                else -> {
                    cycles.add(register)
                    cycles.add(register)
                    register += it.split(" ")[1].toInt()
                }
            }
        }
        val result =
            cycles.getSignalStrength(20) +
            cycles.getSignalStrength(60) +
            cycles.getSignalStrength(100) +
            cycles.getSignalStrength(140) +
            cycles.getSignalStrength(180) +
            cycles.getSignalStrength(220)
        println("The sum of the 6 signal strengths: $result")
    }
}

fun List<Int>.getSignalStrength(indx: Int): Int {
    return this[indx-1] * indx
}
