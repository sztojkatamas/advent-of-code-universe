package hu.advent.of.code.year2017.day4

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle4A: BaseChallenge(2017) {

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
        return parts.map { it to it }.toMap().count() == parts.count()
    }
}