package hu.advent.of.code.year2021.day3

import hu.advent.of.code.BaseChallenge

class Puzzle3B : BaseChallenge(2021) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        println("The life support rating of the submarine: ${calculateOxigenGeneratorRating(data, 0) * calculateCO2ScrubberRating(data, 0)}")
    }

    fun calculateOxigenGeneratorRating(bindata: MutableList<String>, pos: Int): Int {
        val counter = BitCounter("O2")
        val slist = mutableListOf<String>()

        bindata.forEach { counter.bump(it[pos].toString()) }

        val most = counter.getMost()
        bindata.forEach { if (it[pos].toString() == most) { slist.add(it) } }

        return when (slist.size == 1) {
            true -> slist[0].bin2int()
            false -> calculateOxigenGeneratorRating(slist, pos + 1)
        }
    }

    fun calculateCO2ScrubberRating(bindata: MutableList<String>, pos: Int): Int {

        val counter = BitCounter("CO2")
        val slist = mutableListOf<String>()

        bindata.forEach { counter.bump(it[pos].toString()) }

        val least = when (counter.isEqual()) {
            true -> "0"
            else -> counter.getLeast()
        }

        bindata.forEach { if (it[pos].toString() == least) { slist.add(it) } }

        if (slist.size == 1) {
                return slist[0].bin2int()
            } else {
                return calculateCO2ScrubberRating(slist, pos + 1)
        }
    }
}