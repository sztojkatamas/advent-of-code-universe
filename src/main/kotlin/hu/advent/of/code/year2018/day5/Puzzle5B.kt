package hu.advent.of.code.year2018.day5

import hu.advent.of.code.BaseChallenge
import java.util.*

class Puzzle5B: BaseChallenge(2018) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("input5.txt")
        val polymer = data[0]
        var min = data[0].length
        for (i in 65..90) {
            val badUnit = i.toChar().toString()
            val m = polimerize(stripPolimer(badUnit, polymer)).length
            min = if (min < m) min else m
        }
        println("Shortest polymer length: $min")
    }

    fun stripPolimer(badUnit: String, polymer: String): String {
        return polymer.replace(badUnit.lowercase(),"").replace(badUnit.uppercase(),"")
    }

    fun polimerize(rawPolymer: String): String {
        var polymer = rawPolymer
        rawPolymer.forEach {
            val rpc = it.toString().lowercase() + it.toString().uppercase()
            polymer = polymer.replace(rpc, "").replace(rpc.reversed(),"")
        }
        return polymer
    }
}