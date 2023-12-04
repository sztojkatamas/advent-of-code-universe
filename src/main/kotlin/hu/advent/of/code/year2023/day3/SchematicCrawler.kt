package hu.advent.of.code.year2023.day3

class SchematicCrawler(val data: MutableList<String>) {

    fun getNumberToLeft(row: Int, col: Int): Int {
        return getNumberToDirection(row, col, -1)
    }

    fun getNumberToRight(row: Int, col: Int): Int {
        return getNumberToDirection(row, col, 1)
    }

    private fun getNumberToDirection(row: Int, col: Int, direction: Int): Int {
        var shift = 0
        var c = data[row][col]
        var numcollector = ""
        if (c == '.') {
            return 0
        } else {
            if (c.isDigit()) {
                do {
                    numcollector = numcollector.plus(c.toString())
                    shift++
                    if (col + (shift * direction) !in 0 until data[1].length) {
                        break
                    } // Boundary check

                    c = data[row][col + (shift * direction)]
                } while (c.isDigit())
            } else {
                return 0 // A symbol
            }
        }
        if (direction < 0) {
            return numcollector.reversed().toInt()
        }
        return numcollector.toInt()
    }
}