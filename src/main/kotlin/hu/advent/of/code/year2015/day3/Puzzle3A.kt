package hu.advent.of.code.year2015.day3

import hu.advent.of.code.BaseChallenge

class Puzzle3A:BaseChallenge(2015) {
    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        val i = Itinerary(data.first())
        i.walk()
        println(i.getNumberOfVisitedHouses())
    }
}
