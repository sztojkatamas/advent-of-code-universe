package hu.advent.of.code.year2018.day2

import hu.advent.of.code.BaseChallenge

class Puzzle2B: BaseChallenge(2018) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("input2.txt")
        var theResult = ""
        data.forEach { that ->
            repeat(that.length) {
                val i = it + 1
                data.forEach { f ->
                    if (that != f && that.removeNth(i) == f.removeNth(i)) {
                        theResult = that.removeNth(i)
                    }
                }
            }
        }
        println("Common letters: $theResult")
    }
}

fun String.removeNth(i: Int): String {
    return this.take(i-1) + this.takeLast(length - i)
}
