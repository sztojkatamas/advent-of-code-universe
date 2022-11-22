package hu.advent.of.code.year2021.day3

import kotlin.math.pow

//class StringExtension {}

fun String.bin2int(): Int {
    var ret = 0
    this.forEachIndexed { index, value ->
        when (value) {
            '1' -> ret += 2.toDouble().pow((this.length - index - 1).toDouble()).toInt()
        }
    }
    return ret
}
