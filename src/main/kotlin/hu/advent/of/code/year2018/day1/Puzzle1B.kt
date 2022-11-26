package hu.advent.of.code.year2018.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import java.util.TreeSet

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2018) {

    override fun run() {
        printPuzzleName()
        val data = loadIntDataFromFile("input1.txt")

        val frequencies = TreeSet<Int>()
        var sum = 0
        frequencies.add(sum)
        var found = false

        while(!found) {
            data.forEach {
                sum += it
                if (!found && !frequencies.add(sum)) {
                        println("The first duplicated frequency: $sum")
                        found = true
                }
            }
        }
    }
}