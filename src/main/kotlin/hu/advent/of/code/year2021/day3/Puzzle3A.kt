package hu.advent.of.code.year2021.day3

import hu.advent.of.code.BaseChallenge

class Puzzle3A : BaseChallenge(2021) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        println("The power consumption of the submarine: ${calculatePowerConsumption(data)}")
    }

    fun calculatePowerConsumption(bindata: MutableList<String>): Int {
        val len = bindata[0].length
        val counters = mutableListOf<BitCounter>()
        repeat(len) {
            counters.add(BitCounter(it.toString()))
        }
        bindata.forEach { s ->
            repeat(len) {
                counters[it].bump(s[it].toString())
            }
        }

        var gamma = ""
        var epsilon = ""
        repeat(len) {
            gamma = gamma.plus(counters[it].getMost())
            epsilon = epsilon.plus(counters[it].getLeast())
        }

        return gamma.bin2int() * epsilon.bin2int()
        //bin2int(gamma) * bin2int(epsilon)
    }
}

