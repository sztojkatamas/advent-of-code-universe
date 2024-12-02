package hu.advent.of.code.year2024.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import kotlin.math.abs

@AdventOfCodePuzzle
class Puzzle2B: BaseChallenge(2024) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")
        var safeReports = 0
        data.forEach {
            when (isReportSafeWithTolerance(it)) {
                true -> safeReports++
                false -> {}
            }
        }
        println("Number of 'tolerated' safe reports: $safeReports")
    }

    fun isReportSafeWithTolerance(line: String): Boolean {

        val numbers = line.split(" ").map { it.toInt() }.toMutableList()
        repeat(numbers.size) {
            val toleratedNumbers = numbers.toMutableList()
            toleratedNumbers.removeAt(it)

            var toleratedString = ""
            toleratedNumbers.forEach { element ->
                toleratedString += "$element "
            }
            toleratedString = toleratedString.trim()
            if(isReportSafe(toleratedString)) {
                return true
            }
        }
        return false
    }

    private fun isReportSafe(line: String): Boolean {

        val numbers = line.split(" ").map { it.toInt() }
        val diffs = numbers.zipWithNext { a, b -> b - a }

        if (diffs.any { it == 0 }) { return false }
        if (diffs.any { abs(it) > 3 }) { return false }

        val allPositive = diffs.all { it > 0 }
        val allNegative = diffs.all { it < 0 }

        return allPositive || allNegative
    }

}