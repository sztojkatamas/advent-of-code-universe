package hu.advent.of.code.year2020.day10

import hu.advent.of.code.BaseChallenge
import kotlin.math.abs

class Puzzle10A : BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        val data = loadIntDataFromFile("data10.txt").toMutableList()
        data.add(0)
        data.add(data.maxOrNull()!! + 3)

        val distanceList = makeDistanceList(data.sorted())
        println("The answer is: ${distanceList.count { it == 1 } * distanceList.count { it == 3 }}")
    }
}

fun makeDistanceList(listOfNumbers: List<Int>) :MutableList<Int> {
    val ret = mutableListOf<Int>()
    for (i in 0 until listOfNumbers.size-1) {
        ret.add( abs( listOfNumbers[i] - listOfNumbers[i+1]) )
    }
    return ret
}



