package hu.advent.of.code.year2020.day8

import hu.advent.of.code.BaseChallenge

class Puzzle8A : BaseChallenge(2020) {

    private val executedLines = mutableSetOf<Int>()

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data8.txt")
        var currentLine = 0
        var accu = 0
        while (!executedLines.contains(currentLine)) {
            executedLines.add(currentLine)
            val s = data[currentLine].split(" ")
            when (s[0]) {
                "nop" -> {
                    currentLine++
                }
                "acc" -> {
                    accu += s[1].toInt()
                    currentLine++
                }
                "jmp" -> {
                    currentLine += s[1].toInt()
                }
            }
        }
        println("ACCU: $accu")
    }
}