package hu.advent.of.code.year2023.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle3A: BaseChallenge(2023) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        println("The sum of the part numbers: ${gatherNumbers().sum()}")
    }

    fun gatherNumbers(): List<Int> {
        val partNumbers = mutableListOf<Int>()
        val schemaCrawler = SchematicCrawler(data)

        data.forEachIndexed { row, line ->
            line.forEachIndexed { col, char ->
                if (char != '.' && !char.isDigit()) {

                    // Left
                    partNumbers.add(schemaCrawler.getNumberToLeft(row, col-1))

                    // Right
                    partNumbers.add(schemaCrawler.getNumberToRight(row, col+1))

                    // Above
                    if (row > 0) {
                        if (data[row-1][col] == '.') {
                            /*
                            .42.12.
                            ...#...
                            */
                            partNumbers.add(schemaCrawler.getNumberToLeft(row-1, col-1))
                            partNumbers.add(schemaCrawler.getNumberToRight(row-1, col+1))
                        } else if (data[row-1][col-1] == '.') {
                            /*
                            ...123.
                            ...#...
                            */
                            partNumbers.add(schemaCrawler.getNumberToRight(row-1, col))
                        } else if (data[row-1][col+1] == '.') {
                            /*
                            .123...
                            ...#...
                            */
                            partNumbers.add(schemaCrawler.getNumberToLeft(row-1, col))
                        } else if (data[row-1][col-1].isDigit() && data[row-1][col].isDigit() && data[row-1][col+1].isDigit()) {
                            /*
                            ..123..
                            ...#...
                            */
                            partNumbers.add(schemaCrawler.getNumberToRight(row-1, col-1))
                        }
                    }

                    // Below
                    if (row < data.size-1) {
                        if (data[row+1][col] == '.') {
                            /*
                            ...#...
                            .42.12.
                            */
                            partNumbers.add(schemaCrawler.getNumberToLeft(row+1, col-1))
                            partNumbers.add(schemaCrawler.getNumberToRight(row+1, col+1))
                        } else if (data[row+1][col-1] == '.') {
                            /*
                            ...#...
                            ...123.
                            */
                            partNumbers.add(schemaCrawler.getNumberToRight(row+1, col))
                        } else if (data[row+1][col+1] == '.') {
                            /*
                            ...#...
                            .123...
                            */
                            partNumbers.add(schemaCrawler.getNumberToLeft(row+1, col))
                        } else if (data[row+1][col-1].isDigit() && data[row+1][col].isDigit() && data[row+1][col+1].isDigit()) {
                            /*
                            ...#...
                            ..123..
                            */
                            partNumbers.add(schemaCrawler.getNumberToRight(row+1, col-1))
                        }
                    }
                }
            }
        }
        return partNumbers
    }
}
