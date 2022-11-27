package hu.advent.of.code.year2016.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2016) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")


        val position = Pos(0,0)

        data[0].split(", ").forEach {
            when(it[0]) {
                'L' -> position.turnLeft()
                'R' -> position.turnRight()
            }
            position.walk(it.drop(1).toInt())
        }
    }
}



