package hu.advent.of.code.year2022.day11

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import hu.advent.of.code.RunOnlyThis

@AdventOfCodePuzzle
@RunOnlyThis
class Puzzle11B: BaseChallenge(2022) {
    override fun run() {
        printPuzzleName()
        loadDataFromFile("data11.txt")

        val monkeys = buildMonkeys(data)
        repeat(10000) { monkeys.doTheMonkeyBusiness(false) }
        val mm = monkeys.sortedByDescending { it.inspection }
        println("Level of monkey business without calming: ${mm[0].inspection * mm[1].inspection}")
    }
}