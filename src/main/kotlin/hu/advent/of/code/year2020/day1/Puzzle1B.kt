package hu.advent.of.code.year2020.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        val data = loadIntDataFromFile("data1.txt")

        for(A in data) {
            for(B in data) {
                for(C in data) {
                    if(A + B + C == 2020) {
                        println("A: $A")
                        println("B: $B")
                        println("C: $C")
                        println("Answer: ${A * B * C}")
                        return
                    }
                }
            }
        }
    }
}