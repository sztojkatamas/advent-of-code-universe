package hu.advent.of.code.year2020.day5

import hu.advent.of.code.BaseChallenge

class Puzzle5B : BaseChallenge(2020) {
    private var seats = mutableListOf<String>()

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data5.txt")
        for (i in 0..127) {
            seats.add("        ")
        }


        data.forEach { calculateRow(it) }

        for (i in seats.indices) {
            if (i > 2 && seats[i].toCharArray().contains(' ')) {
                println("My ID: ${i * 8 + seats[i].indexOf(' ', 0, false)}")
                break
            }
        }
    }

    private fun createIntList(length: Int) : MutableList<Int> {
        val list = mutableListOf<Int>()
        for (i in 0 until length) {
            list.add(i)
        }
        return list
    }

    private fun calculateRow(str :String) : Int {
        var seatRows = createIntList(128)
        var seatCols = createIntList(8)


        for (s in str) {
            when (s) {
                'F' -> {
                    seatRows = seatRows.take(seatRows.size / 2).toMutableList()
                }
                'B' -> {
                    seatRows = seatRows.takeLast(seatRows.size / 2).toMutableList()
                }
                'R' -> {
                    seatCols = seatCols.takeLast(seatCols.size / 2).toMutableList()
                }
                'L' -> {
                    seatCols = seatCols.take(seatCols.size / 2).toMutableList()
                }
                else -> {
                    println("Something is wrong")
                }
            }

        }
        mark(seatRows[0], seatCols[0])
        return seatRows[0] * 8 + seatCols[0]
    }

    private fun mark(row :Int, col :Int) {
        val s = seats[row].toCharArray()
        s[col] = 'X'
        seats[row] = s.concatToString()
    }
}