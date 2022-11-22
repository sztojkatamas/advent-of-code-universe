package hu.advent.of.code.year2020.day1

import hu.advent.of.code.BaseChallenge

class Puzzle1A: BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        val data = loadIntDataFromFile("data1.txt")

        for(A in data) {
            for(B in data) {
                if(A + B == 2020) {
                    println("A: $A")
                    println("B: $B")
                    println("Answer: ${A * B}")
                    return
                }
            }
        }
    }
}