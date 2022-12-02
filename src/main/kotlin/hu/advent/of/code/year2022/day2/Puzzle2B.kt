package hu.advent.of.code.year2022.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2B: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        var totalScore = 0
        data.forEach { totalScore += getSillyGameOutcome(it[0], it[2]) }
        println("\"Rock Paper Scissors\" total silly score: $totalScore")
    }

    private fun getSillyGameOutcome(enemyHand :Char, desiredOutcome :Char): Int {
        return when (desiredOutcome) {
            'X' -> when (enemyHand) { // Lose
                'A' -> 3
                'B' -> 1
                else -> 2
            }
            'Z' -> when (enemyHand) { // Win
                'A' -> 8
                'B' -> 9
                else -> 7
            }
            else -> when (enemyHand) { // Draw
                'A' -> 4
                'B' -> 5
                else -> 6
            }
        }
    }

}