package hu.advent.of.code.year2020.day4

import hu.advent.of.code.BaseChallenge

class Puzzle4A: BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data4.txt")

        val listOfPassports = PassportLoader.createPassportsFromRawData(data)
        val valids = listOfPassports.filter { it.isValid() }.count()

        println("There are $valids valid passports.")
    }
}