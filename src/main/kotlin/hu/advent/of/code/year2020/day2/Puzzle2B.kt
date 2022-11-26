package hu.advent.of.code.year2020.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2B: BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        println("Number of valid passwords are: ${data.count { PasswordPolicyAdvanced(it).isValid() }}")
    }
}

class PasswordPolicyAdvanced(input:String) {

    private var min = 0
    private var max = 0
    private var character = ""
    private var password = ""

    init {
        val splittedLine = input.trim().split(" ")

        val minmax = splittedLine[0].split("-")
        min = minmax[0].toInt()
        max = minmax[1].toInt()

        val len = splittedLine[1].trim().length - 1
        character = splittedLine[1].trim().substring(0, len)

        password = splittedLine[2].trim()
    }

    fun isValid() : Boolean {
        return ((password[max - 1].toString() == character) xor (password[min - 1].toString() == character))
    }
}