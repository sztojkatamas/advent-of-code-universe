package hu.advent.of.code.year2018.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2A : BaseChallenge(2018) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("input2.txt")
        var twos = 0
        var threes = 0
        data.forEach {
            twos += checkString(it, 2)
            threes += checkString(it, 3)
        }
        println("Checksum : ${twos * threes}")

    }

    fun checkString(s: String, freq: Int): Int {
        s.forEach { that ->
            if (freq == s.windowed(1).count { it == that.toString() }) { return 1 }
        }
        return 0
    }
}