package hu.advent.of.code.year2017.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1A: BaseChallenge(2017) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        println("Captcha: ${captchaSolver(data[0])}")
    }

    fun captchaSolver(captcha: String) : Int {
        var s = 'x'
        var sum = 0
        val ll = captcha + captcha[0]
        ll.forEach { c ->
            if (s==c) {
                sum += c.code - '0'.code
            } else {
                s=c
            }
        }
        return sum
    }
}