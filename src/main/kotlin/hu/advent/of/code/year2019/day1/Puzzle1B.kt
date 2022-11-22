package hu.advent.of.code.year2019.day1

import hu.advent.of.code.BaseChallenge

class Puzzle1B: BaseChallenge(2019) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        var fuel = 0
        data.forEach( fun(s: String) {
            fuel += calculateFuelForTotalMassWithFuel(s.toInt())
        })
        println("Total fuel (with fuel): $fuel")
    }

    fun calculateFuelForTotalMassWithFuel(mass: Int): Int {
        val fuel = (mass/3)-2
        return when(fuel>0) {
            true -> fuel + calculateFuelForTotalMassWithFuel(fuel)
            false -> 0
        }
    }
}