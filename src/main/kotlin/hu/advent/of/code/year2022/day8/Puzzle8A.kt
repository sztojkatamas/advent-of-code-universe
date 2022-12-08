package hu.advent.of.code.year2022.day8

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle8A: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data8.txt")
        val rows = data.makeRows()
        val cols = data.makeCols()
        println("Total number of visible trees: ${countVisibleTrees(rows, cols)}")
    }

    fun countVisibleTrees(rows: List<List<Int>>, cols: List<List<Int>>): Int {
        val width = rows[0].size
        val height = cols[0].size
        var numberOfVisibleTrees = 2 * (width + height) - 4 // The sides

        for ( x in 1 until width - 1) {
            for ( y in 1 until height - 1) {
                val self = rows[x][y]
                val left = rows[x].take(y)
                val right = rows[x].takeLast(width - y - 1)
                val top = cols[y].take(x)
                val bottom = cols[y].takeLast(height - x - 1)
                val maxes = listOf(top.max(), bottom.max(), left.max(), right.max())

                if (self > maxes.min()) { // when visible
                    numberOfVisibleTrees++
                }
            }
        }
        return numberOfVisibleTrees
    }
}
fun List<String>.makeRows(): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    this.forEach { line ->
        val row = mutableListOf<Int>()
        line.forEach {
            row.add(it.digitToInt())
        }
        res.add(row)
    }
    return res
}

fun List<String>.makeCols(): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    repeat(this[0].length) {
        res.add(mutableListOf())
    }
    this.forEach { line ->
        line.forEachIndexed { i, c ->
            res[i].add(c.digitToInt())
        }
    }
    return res
}