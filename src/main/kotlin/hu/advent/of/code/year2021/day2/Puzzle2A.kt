package hu.advent.of.code.year2021.day2

import hu.advent.of.code.BaseChallenge

class Puzzle2A: BaseChallenge(2021) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        println("Position value: ${calculatePosition(data)}")
    }

    fun calculatePosition(directions: MutableList<String>) : Int {
        var x = 0
        var depth = 0
        directions.forEach {
            val dir = it.split(" ")
            when (dir[0]) {
                "forward" -> x += dir[1].toInt()
                "up" -> depth -= dir[1].toInt()
                "down" -> depth += dir[1].toInt()
            }
        }
        return x * depth
    }


}