package hu.advent.of.code.year2022.day4

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle4B: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data4.txt")
        var overlaps = 0
        data.forEach {
            val ranges = it.split(",","-")
            val r1 = ranges[0].toInt()..ranges[1].toInt()
            val r2 = ranges[2].toInt()..ranges[3].toInt()
            if (r1.intersect(r2).isNotEmpty()) {
                overlaps++
            }
        }
        println("Cleanup overlaps: $overlaps")
    }
}