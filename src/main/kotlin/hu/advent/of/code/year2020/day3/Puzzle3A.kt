package hu.advent.of.code.year2020.day3

import hu.advent.of.code.BaseChallenge

class Puzzle3A: BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        val data = Maputils.expandMap(data, 100)
        val position = Position(0,0)
        var treecounter = 0

        while (position.y < data.size) {
            if(Maputils.mark(data, position)) {
                treecounter++
            }
            position.x = position.x+ 3
            position.y++
        }

        println("Hit $treecounter trees")
    }

}