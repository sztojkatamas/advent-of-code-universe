package hu.advent.of.code.year2021.day3

class BitCounter(val name: String) {
    private var zeros = 0
    private var ones = 0

    fun bump(c: String) {
        when (c) {
            "0" -> zeros++
            "1" -> ones++
        }
    }

    fun getMost() : String {
        return when (zeros > ones) {
            true -> "0"
            else -> "1"
        }
    }

    fun getLeast() : String {
        return when (zeros < ones) {
            true -> "0"
            else -> "1"
        }
    }

    fun isEqual(): Boolean {
        return zeros == ones
    }
}