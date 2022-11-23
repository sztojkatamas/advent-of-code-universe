package hu.advent.of.code.year2018.day5

import hu.advent.of.code.BaseChallenge

class Puzzle5A: BaseChallenge(2018) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("input5.txt")
        println("Remaining units: ${polimerize(data[0]).length}")
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