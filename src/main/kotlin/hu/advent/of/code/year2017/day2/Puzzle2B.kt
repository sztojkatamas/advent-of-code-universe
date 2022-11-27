package hu.advent.of.code.year2017.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2B: BaseChallenge(2017) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")

        var checksum = 0
        data.forEach {
            val nums =it.split("\t")
            checksum += findEvenDivisions(nums)
        }
        println("Sum of even divisions : $checksum")
    }

    private fun findEvenDivisions(list: List<String>) : Int {
        list.forEach {
            val x = it.toInt()
            list.forEach {
                val y = it.toInt()
                if(x!=y && x.mod(y) == 0) {
                    return x/y
                }
            }
        }
        return -1
    }
}