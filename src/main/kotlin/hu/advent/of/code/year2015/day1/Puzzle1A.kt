package hu.advent.of.code.year2015.day1

import hu.advent.of.code.BaseChallenge


class Puzzle1A: BaseChallenge(2015) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")

        val up = data.first().count { it.equals('(') }
        val down = data.first().count { it.equals(')') }
        println("Floor: ${up-down}")
    }


}