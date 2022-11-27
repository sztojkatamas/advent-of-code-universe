package hu.advent.of.code.year2017.day4

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle4B: BaseChallenge(2017) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data4.txt")
        var validPasswords = 0
        data.forEach {
            if(isLineValid(it)) {
                validPasswords++
            }
        }
        println("There are $validPasswords valid passwords")
    }

    fun isLineValid(line: String): Boolean{
        val parts = line.split(" ")
        val sorted = mutableListOf<String>()
        parts.forEach { sorted.add(it.sort()) }
        return sorted.map { it to it }.toMap().count() == sorted.count()
    }
}

fun String.sort() : String {
    return this.toCharArray().sorted().joinToString("")
}