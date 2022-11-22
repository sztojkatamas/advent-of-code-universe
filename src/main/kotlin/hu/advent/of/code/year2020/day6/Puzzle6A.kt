package hu.advent.of.code.year2020.day6

import hu.advent.of.code.BaseChallenge

class Puzzle6A : BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data6.txt")

        val listOfGroups = mutableListOf<GroupOfPeople>()
        var groupOfPeople = GroupOfPeople()
        listOfGroups.add(groupOfPeople)

        for (line in data) {
            if (!groupOfPeople.processLine(line)) {
                groupOfPeople = GroupOfPeople()
                listOfGroups.add(groupOfPeople)
            }
        }

        println("Sum of YES answers: ${listOfGroups.sumOf { it.getAnswers() }}")
    }
}