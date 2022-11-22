package hu.advent.of.code.year2020.day9

import hu.advent.of.code.BaseChallenge

class Puzzle9B : BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        val data = loadLongDataFromFile("data9.txt")
        val preamble = 25
        val num = getThatNumber(data, preamble)

        val limitpos = data.indexOf(num)
        for (s in 1 until limitpos) {
            print("${(s/limitpos.toFloat())*100f}%  [$s\t$limitpos]\r")
            for (i in 1 until data.size) {
                val potentialData = data.takeFrom(s-1, i)
                val sum = potentialData.sumOf { it }
                when {
                    sum == num -> {
                        println("--== Finally, after crunching ${(s/limitpos.toFloat())*100f}% of the data. ==--\n" +
                                "${potentialData.minOrNull()!! + potentialData.maxOrNull()!!}")
                        return
                    }
                    sum > num -> {
                        break
                    }
                }
            }
        }
    }

    private fun getThatNumber(data :List<Long>, preamble :Int): Long {
        for (i in 1..(data.size - preamble)) {
            val workData = data.takeFrom(i-1, preamble)
            val wannabe  = data[i -1 + preamble]

            val pair = hasValidNumbers(workData, wannabe)
            if (pair.first * pair.second == 1L) {
                return wannabe
            }
        }
        return -1L
    }

    private fun hasValidNumbers(workData :List<Long>, target :Long): Pair<Long, Long> {
        for (a in workData) {
            for (b in workData) {
                if ((a + b) == target ) {
                    return Pair(a, b)
                }
            }
        }
        return Pair(-1L, -1L)
    }

    private fun List<Long>.takeFrom(from :Int, n :Int) :List<Long> {
        return this.take(from + n).takeLast(n)
    }
}

