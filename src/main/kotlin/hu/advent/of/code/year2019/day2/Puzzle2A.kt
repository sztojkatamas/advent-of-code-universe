package hu.advent.of.code.year2019.day2

import hu.advent.of.code.BaseChallenge

class Puzzle2A: BaseChallenge(2019) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        val split = data.first().split(",")
        val rawData = IntArray(split.size)

        split.withIndex().forEach {
            rawData[it.index] = it.value.toInt()
        }
        rawData[1] = 12
        rawData[2] = 2
        val processedData = IntCodeProgramRunner.processCode(rawData)
        println("Value at position 0 is ${processedData[0]}")
    }

}