package hu.advent.of.code.year2022.day8

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle8B: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data8.txt")
        val rows = data.makeRows()
        val cols = data.makeCols()
        println("The highest scenic score: ${getMaxScenicScore(rows, cols)}")
    }

    fun getMaxScenicScore(rows: List<List<Int>>, cols: List<List<Int>>): Int {
        val width = rows[0].size
        val height = cols[0].size
        val scores = mutableSetOf<Int>()

        for ( x in 1 until width - 1) {
            for ( y in 1 until height - 1) {
                val self = rows[x][y]
                val left = rows[x].take(y)
                val right = rows[x].takeLast(width - y - 1)
                val top = cols[y].take(x)
                val bottom = cols[y].takeLast(height - x - 1)
                val maxes = listOf(top.max(), bottom.max(), left.max(), right.max())

                if (self > maxes.min()) { // when visible
                    scores.add(
                        top.reversed().viewDistance(self)
                        * bottom.viewDistance(self)
                        * left.reversed().viewDistance(self)
                        * right.viewDistance(self)
                    )
                }
            }
        }
        return scores.max()
    }
}

fun List<Int>.viewDistance(num: Int): Int {
    return when {
        (num > this.max()) -> this.size
        else -> this.indexOfFirst { it >= num } + 1
    }
}
