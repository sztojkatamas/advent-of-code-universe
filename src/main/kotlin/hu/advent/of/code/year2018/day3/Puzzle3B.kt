package hu.advent.of.code.year2018.day3

import hu.advent.of.code.BaseChallenge


class Puzzle3B: BaseChallenge(2018) {

    private val claims = ArrayList<FabricClaim>()
    private val CLOTHSIZE = 1000
    private val cloth = Array(CLOTHSIZE) {
        IntArray(
            CLOTHSIZE
        )
    }
    private var idThatDoesNotOverlap = -1

    override fun run() {
        printPuzzleName()
        loadDataFromFile("input3.txt")
        for (i in data.indices) {
            val xxx = data[i].split(",|:|x|@".toRegex()).dropLastWhile { it.isEmpty() }
            val claim = FabricClaim(xxx)
            claims.add(claim)
        }
        claims.forEach(::putClaimOnCloth)
        claims.forEach(::sliceBack)
        println("The non-overlapping claim id: $idThatDoesNotOverlap")
    }

    private fun putClaimOnCloth(claim: FabricClaim) {
        for (x in claim.x until claim.width + claim.x) {
            for (y in claim.y until claim.height + claim.y) {
                cloth[x][y] = cloth[x][y] + 1
            }
        }
    }

    private fun sliceBack(claim: FabricClaim) {
        if (idThatDoesNotOverlap == -1) {
            for (x in claim.x until claim.width + claim.x) {
                for (y in claim.y until claim.height + claim.y) {

                    if (cloth[x][y] != 1) {
                        return
                    }
                }
            }
            idThatDoesNotOverlap = claim.id.substring(1).toInt()
        }
    }
}