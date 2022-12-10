package hu.advent.of.code.year2022.day10

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle10B: BaseChallenge(2022) {

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

        println("\n\n")
        cycles.windowed(40, 40).forEach {
            print("    ")
            it.forEachIndexed { index, i ->
                when (index) {
                    in i-1..i+1 -> { print("▓") }
                    else -> { print(" ") }
                }
                Thread.sleep(20)
            }
            println()
        }
    }
}