package hu.advent.of.code.year2023.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle3B: BaseChallenge(2023) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        println("The sum of the gear ratios: ${gatherGearRatios().sum()}")
    }

    fun gatherGearRatios(): List<Int> {
        val gearRatios = mutableListOf<Int>()
        val schemaCrawler = SchematicCrawler(data)

        data.forEachIndexed { row, line ->
            line.forEachIndexed { col, char ->
                val gearParts = mutableListOf<Int>()
                if (char == '*') { //(char != '.' && !char.isDigit()) {

                    // Left
                    gearParts.add(schemaCrawler.getNumberToLeft(row, col-1))

                    // Right
                    gearParts.add(schemaCrawler.getNumberToRight(row, col+1))

                    // Above
                    if (row > 0) {
                        if (data[row-1][col] == '.') {
                            /*
                            .42.12.
                            ...#...
                            */
                            gearParts.add(schemaCrawler.getNumberToLeft(row-1, col-1))
                            gearParts.add(schemaCrawler.getNumberToRight(row-1, col+1))
                        } else if (data[row-1][col-1] == '.') {
                            /*
                            ...123.
                            ...#...
                            */
                            gearParts.add(schemaCrawler.getNumberToRight(row-1, col))
                        } else if (data[row-1][col+1] == '.') {
                            /*
                            .123...
                            ...#...
                            */
                            gearParts.add(schemaCrawler.getNumberToLeft(row-1, col))
                        } else if (data[row-1][col-1].isDigit() && data[row-1][col].isDigit() && data[row-1][col+1].isDigit()) {
                            /*
                            ..123..
                            ...#...
                            */
                            gearParts.add(schemaCrawler.getNumberToRight(row-1, col-1))
                        }
                    }

                    // Below
                    if (row < data.size-1) {
                        if (data[row+1][col] == '.') {
                            /*
                            ...#...
                            .42.12.
                            */
                            gearParts.add(schemaCrawler.getNumberToLeft(row+1, col-1))
                            gearParts.add(schemaCrawler.getNumberToRight(row+1, col+1))
                        } else if (data[row+1][col-1] == '.') {
                            /*
                            ...#...
                            ...123.
                            */
                            gearParts.add(schemaCrawler.getNumberToRight(row+1, col))
                        } else if (data[row+1][col+1] == '.') {
                            /*
                            ...#...
                            .123...
                            */
                            gearParts.add(schemaCrawler.getNumberToLeft(row+1, col))
                        } else if (data[row+1][col-1].isDigit() && data[row+1][col].isDigit() && data[row+1][col+1].isDigit()) {
                            /*
                            ...#...
                            ..123..
                            */
                            gearParts.add(schemaCrawler.getNumberToRight(row+1, col-1))
                        }
                    }
                    gearParts.removeIf { it == 0 }
                    if (gearParts.size == 2) {
                        gearRatios.add(gearParts[0] * gearParts[1])
                    }
                }
            }
        }
     return gearRatios
    }
}