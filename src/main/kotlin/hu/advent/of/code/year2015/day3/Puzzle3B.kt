package hu.advent.of.code.year2015.day3

import hu.advent.of.code.BaseChallenge

class Puzzle3B:BaseChallenge(2015) {
    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        val itinerary = Itinerary(data.first())
        val i1 = Itinerary(itinerary.getPath(Itinerary.SANTA))
        val i2 = Itinerary(itinerary.getPath(Itinerary.ROBOT))

        val m = i1.walk().map + i2.walk().map

        println("Santa with Robot: ${m.filter { it.value >= 1 }.count()}")
    }
}
