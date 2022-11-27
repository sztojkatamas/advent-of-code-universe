package hu.advent.of.code.year2017.day2

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle2A: BaseChallenge(2017) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data2.txt")

        var checksum = 0
        data.forEach {
            val nums =it.split("\t")
            checksum += getMax(nums) - getMin(nums)
        }
        println("The checksum is : $checksum")
    }

    private fun getMax(list: List<String>) : Int{
        var max = 0
        list.forEach {
            max = when (it.toInt() > max) {
                true -> it.toInt()
                else -> max
            }
        }
        return max
    }

    private fun getMin(list: List<String>) : Int{
        var min = Int.MAX_VALUE
        list.forEach {
            min = when (it.toInt() < min) {
                true -> it.toInt()
                else -> min
            }
        }
        return min
    }
}