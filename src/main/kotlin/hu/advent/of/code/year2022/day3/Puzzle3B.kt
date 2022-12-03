package hu.advent.of.code.year2022.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle3B: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        var sumPriorities = 0
        val elvenGroups = data.windowed(3,3)
        elvenGroups.forEach { sumPriorities += findBadge(it) }
        println("Rucksack badge priority sum: $sumPriorities")
    }

    fun findBadge(threeElves :List<String>) :Int {
        return threeElves[0].toSet()
            .intersect(threeElves[1].toSet())
            .intersect(threeElves[2].toSet())
            .first().toPriority()
    }
}