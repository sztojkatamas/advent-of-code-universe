package hu.advent.of.code.year2015.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2015) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        val s = data.first()
        var i = 0
        while (calculateFloor(s.substring(0,i)) != -1) {
            i++
        }
        println("Floor: $i")
    }

    private fun calculateFloor(s:String):Int {
        val up = s.count { it.equals('(') }
        val down = s.count { it.equals(')') }
        return up-down
    }


}