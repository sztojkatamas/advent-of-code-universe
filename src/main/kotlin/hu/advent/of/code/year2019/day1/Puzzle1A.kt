package hu.advent.of.code.year2019.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1A: BaseChallenge(2019) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        var fuel = 0
        data.forEach( fun(s: String) {
            fuel += calculateFuelForMass(s.toInt())
        })
        println("Total fuel: $fuel")
    }

    fun calculateFuelForMass(mass: Int): Int {
        return (mass/3)-2
    }
}