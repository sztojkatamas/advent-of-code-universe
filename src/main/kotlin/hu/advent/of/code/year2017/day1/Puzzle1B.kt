package hu.advent.of.code.year2017.day1

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle1B: BaseChallenge(2017) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data1.txt")
        println("Advanced captcha: ${advancedCaptchaSolver(data[0])}")
    }

    fun advancedCaptchaSolver(captcha: String) : Int {
        val half = captcha.length / 2
        val s1 = captcha.take(half)
        val s2 = captcha.takeLast(half)
        var sum = 0
        repeat(half) {
            if (s1[it] == s2[it]) {
                sum += (s1[it].code - '0'.code) *2
            }
        }
        return sum
    }
}