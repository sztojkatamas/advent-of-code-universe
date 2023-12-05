package hu.advent.of.code.year2023.day4

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import kotlin.math.pow

@AdventOfCodePuzzle
class Puzzle4A: BaseChallenge(2023) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data4.txt")

        var sum = 0
        data.forEach { line ->
            val splittedLine = line.split(":","|")
            val card = splittedLine[1].split(" ").filter { it != "" }.toSet()
            val hand = splittedLine[2].split(" ").filter { it != "" }.toSet()

            sum += 2.0.pow(((card intersect hand).size - 1).toDouble()).toInt()
        }
        println("Card points: $sum")
    }
}