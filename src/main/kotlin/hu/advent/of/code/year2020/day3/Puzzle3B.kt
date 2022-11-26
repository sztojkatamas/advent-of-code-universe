package hu.advent.of.code.year2020.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle3B: BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        println("${runSlope(1,1) * runSlope(3,1) * runSlope(5,1) * runSlope(7,1) * runSlope(1,2)}")
    }

    private fun runSlope(xInc :Int, yInc :Int) : Long {
        val data = Maputils.expandMap(data, 100)
        val position = Position(0,0)
        var treecounter = 0L

        while (position.y < data.size) {
            if(Maputils.mark(data, position)) {
                treecounter++
            }
            position.x = position.x + xInc
            position.y = position.y + yInc
        }

        println("($xInc, $yInc) -> Hit $treecounter trees")
        return treecounter
    }
}