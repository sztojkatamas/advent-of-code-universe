package hu.advent.of.code.year2020.day9

import hu.advent.of.code.BaseChallenge

class Puzzle9A : BaseChallenge(2020) {

    override fun run() {
        printPuzzleName()
        val data = loadLongDataFromFile("data9.txt")
        val preamble = 25

        for (i in 1..(data.size - preamble)) {
            val workData = data.takeFrom(i-1, preamble)
            val wannabe  = data[i -1 + preamble]
            var found = false

            for (a in workData) {
                for (b in workData) {
                    if ((a + b) == wannabe ) {
                        found = true
                        break
                    }
                }
            }

            if (!found) {
                println("Number $wannabe at ${i + preamble} is corrupt.")
                return
            }
        }
    }

    private fun List<Long>.takeFrom(from :Int, n :Int) :List<Long> {
        return this.take(from + n).takeLast(n)
    }
}