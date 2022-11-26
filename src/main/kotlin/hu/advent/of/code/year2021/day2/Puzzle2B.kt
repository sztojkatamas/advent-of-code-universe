package hu.advent.of.code.year2021.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2B: BaseChallenge(2021) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        println("Position value: ${calculateAdvancedPosition(data)}")
    }

    fun calculateAdvancedPosition(directions: MutableList<String>) : Int {
        var x = 0
        var depth = 0
        var aim = 0
        directions.forEach {
            val dir = it.split(" ")
            when (dir[0]) {
                "forward" -> {
                    x += dir[1].toInt()
                    depth += dir[1].toInt() * aim
                }
                "up" -> aim -= dir[1].toInt()
                "down" -> aim += dir[1].toInt()
            }
        }
        return x * depth
    }


}