package hu.advent.of.code.year2023.day4

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle4B: BaseChallenge(2023) {

    override fun run() {
        printPuzzleName()

        loadDataFromFile("data4.txt")

        val scoreMap = mutableMapOf<Int, Int>()
        val cards = mutableListOf<Int>()

        // Init
        repeat(data.size) { cards.add(1) }

        data.forEach { line ->
            val splittedLine = line.split(":","|")
            val card = splittedLine[1].split(" ").filter { it != "" }.toSet()
            val hand = splittedLine[2].split(" ").filter { it != "" }.toSet()

            scoreMap[splittedLine[0].split(" ").filter { it != "" }[1].toInt()] = (card intersect hand).size
        }

        cards.forEachIndexed { idx, num ->
            repeat(num) {
                repeat(scoreMap[idx+1]!!.toInt()) {
                    cards[idx + 1 + it] = cards[idx + 1 + it] + 1
                }
            }
        }

        println("Total number of scratchcards: " + cards.sum())
    }
}