package hu.advent.of.code.year2022.day6

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle6A: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data6.txt")
        println("Packet marker is at place ${data[0].findMarker(4)}")
    }
}

fun String.findMarker(window :Int): Int {
    val x = this.windowed(window,1)
    x.forEachIndexed { index, s ->
        if (!s.hasMoreSameCharacters()) {
            return index + window
        }
    }
    return 0
}

fun String.hasMoreSameCharacters(): Boolean {
    val freq = mutableMapOf<Char, Int>()
    this.forEach {
        when (freq[it]) {
            null -> freq[it] = 1
            else -> return true
        }
    }
    return false
}