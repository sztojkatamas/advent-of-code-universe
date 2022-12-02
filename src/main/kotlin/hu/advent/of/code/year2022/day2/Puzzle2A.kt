package hu.advent.of.code.year2022.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2A: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        var totalScore = 0
        data.forEach { totalScore += getGameOutcome(it) }
        println("\"Rock Paper Scissors\" total score: $totalScore")
    }

    fun getGameOutcome(input :String) :Int {
        var hands = input
        hands = hands.replace("X","A")
        hands = hands.replace("Y","B")
        hands = hands.replace("Z","C")
        return when (hands) {
            "A A" -> 4
            "B B" -> 5
            "C C" -> 6
            "A B" -> 8
            "B A" -> 1
            "A C" -> 3
            "C A" -> 7
            "B C" -> 9
            "C B" -> 2
            else -> 0
        }
    }

}