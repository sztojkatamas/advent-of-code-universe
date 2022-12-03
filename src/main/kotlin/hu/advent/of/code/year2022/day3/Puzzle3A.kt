package hu.advent.of.code.year2022.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle3A: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        var sumPriorities = 0
        data.forEach { sumPriorities += rucksackPriority(it) }
        println("Rucksack priority sum: $sumPriorities")
    }

    fun rucksackPriority(stuff :String) :Int {
        val compartmentA = stuff.take(stuff.length/2).toSet()
        val compartmentB = stuff.takeLast(stuff.length/2).toSet()
        return compartmentA.intersect(compartmentB).first().toPriority()
    }
}

fun Char.toPriority(): Int {
    return when(this.isUpperCase()) {
        true -> this.code - 38
        false -> this.code - 96
    }
}
