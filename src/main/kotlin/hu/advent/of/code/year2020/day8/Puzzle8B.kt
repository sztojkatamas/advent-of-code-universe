package hu.advent.of.code.year2020.day8

import hu.advent.of.code.BaseChallenge

class Puzzle8B : BaseChallenge(2020) {

    private val executedLines = mutableSetOf<Int>()

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data8.txt")
        var occurence = 1

        var work = changeAToB(data, occurence, "jmp", "nop")
        occurence++

        while (!runProgram(work) && occurence < data.size) {
            work = changeAToB(data, occurence, "jmp", "nop")
            occurence++
        }

        occurence = 1
        work = changeAToB(data, occurence, "nop", "jmp")
        occurence++
        while (!runProgram(work) && occurence < data.size) {
            work = changeAToB(data, occurence, "nop", "jmp")
            occurence++
        }
    }

    private fun changeAToB(orig: List<String>, occurence: Int, fromStr :String, toStr :String): List<String> {
        val newData = orig.toMutableList()
        var found = 0
        for (i in newData.indices) {
            if (newData[i].contains(fromStr)) {
                found++
            }
            if (found == occurence) {
                newData[i] = newData[i].replace(fromStr,  toStr)
                return newData
            }
        }
        return newData
    }

    private fun runProgram(workdata :List<String>) : Boolean {
        executedLines.clear()
        var currentLine = 0
        var accu = 0
        while (!executedLines.contains(currentLine)) {
            executedLines.add(currentLine)
            if (currentLine == workdata.size) {
                println("ACCU: $accu")
                return true
            }
            val s = workdata[currentLine].split(" ")
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
        return false
    }
}