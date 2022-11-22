package hu.advent.of.code.year2015.day5

import hu.advent.of.code.BaseChallenge

class Puzzle5A:BaseChallenge(2015) {
    override fun run() {
        printPuzzleName()
        loadDataFromFile("data5.txt")
        val numberOfNiceStrings = data.filter { isNice(it) }.count()
        println("Nice Strings: $numberOfNiceStrings")
    }

    private operator fun String.minus(s: String): String {
        return this.replace(s, "")
    }

    fun isNice(stringToCheck:String ):Boolean {
        if ( (stringToCheck - "ab" - "cd" - "pq" - "xy").length == stringToCheck.length
                && hasDoubles(stringToCheck)
                && hasThreeVowels(stringToCheck)) {
            return true
        }
        return false
    }


    fun hasThreeVowels(stringToCheck: String):Boolean {
        var sum = 0
        sum += stringToCheck.count{"a".contains(it)}
        sum += stringToCheck.count{"e".contains(it)}
        sum += stringToCheck.count{"i".contains(it)}
        sum += stringToCheck.count{"o".contains(it)}
        sum += stringToCheck.count{"u".contains(it)}
        return (sum > 2)
    }

    fun hasDoubles(stringToCheck: String):Boolean {
        if (stringToCheck.length < 2) {
            return false
        }
        for (i in 2..stringToCheck.length) {
            if (stringToCheck[i-2] - stringToCheck[i-1] == 0) {
                    return true
                }
        }
        return false
    }

}
