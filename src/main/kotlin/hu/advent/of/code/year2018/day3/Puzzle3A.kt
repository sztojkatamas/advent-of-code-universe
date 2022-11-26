package hu.advent.of.code.year2018.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle3A: BaseChallenge(2018) {

    private val claims = ArrayList<FabricClaim>()
    private val CLOTHSIZE = 1000
    private val cloth = Array(CLOTHSIZE) {
        IntArray(
            CLOTHSIZE
        )
    }

    override fun run() {
        printPuzzleName()
        loadDataFromFile("input3.txt")

        for (i in data.indices) {
            val xxx = data[i].split(",|:|x|@".toRegex()).dropLastWhile { it.isEmpty() }//.toTypedArray()
            val claim = FabricClaim(xxx)
            claims.add(claim)
        }

        claims.forEach(this::putClaimOnCloth)
        println("Overlapping claims in square inches: ${countOverlap()}")


    }

    private fun putClaimOnCloth(claim: FabricClaim) {
        for (x in claim.x until claim.width + claim.x) {
            for (y in claim.y until claim.height + claim.y) {
                cloth[x][y] = cloth[x][y] + 1
            }
        }
    }

    private fun countOverlap(): Int {
        var sq = 0
        for (x in 0 until CLOTHSIZE) {
            for (y in 0 until CLOTHSIZE) {
                if (cloth[x][y] > 1) {
                    sq++
                }
            }
        }
        return sq
    }
}