package hu.advent.of.code.year2019.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2B: BaseChallenge(2019) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        val split = data.first().split(",")
        val rawData = IntArray(split.size)

        split.withIndex().forEach { rawData[it.index] = it.value.toInt() }

        for (noun in 0..99) {
            for (verb in 0..99) {
                rawData[1] = noun
                rawData[2] = verb
                if (IntCodeProgramRunner.processCode(rawData)[0] == 19690720) {
                    println("Noun: $noun, Verb $verb. Answer: ${100*noun+verb}")
                    break
                }
            }
        }
    }
}