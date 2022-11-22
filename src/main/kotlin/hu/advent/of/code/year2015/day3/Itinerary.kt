package hu.advent.of.code.year2015.day3

class Itinerary(private val pathString: String) {
    var map = mutableMapOf<String, Int>()
        private set


    companion object {
        const val SANTA = "Santa"
        const val ROBOT = "Robot"
    }

    fun walk(): Itinerary {
        val santa = Pos(0,0)
        markOnMap(santa)

        for (c in pathString.asSequence()) {
            when(c) {
                '>' -> santa.right()
                '<' -> santa.left()
                '^' -> santa.up()
                'v' -> santa.down()
            }
            markOnMap(santa)
        }
        return this
    }

    private fun markOnMap(position: Pos) {
        val v = map[position.getPosString()]
        if (null == v) {
            map[position.getPosString()] = 1
        } else {
            map[position.getPosString()] = v+1
        }
    }

    fun getNumberOfVisitedHouses():Int {
        return map.filter { it.value >= 1 }.count()
    }

    fun getPath(person: String): String {
        var retString:String = ""
        when (person) {
            SANTA -> {
                for (a in 0..pathString.length-1 step 2) {
                    retString += pathString[a]
                }
            }
            ROBOT -> {
                for (a in 1..pathString.length-1 step 2) {
                    retString += pathString[a]
                }
            }
        }
        return retString
    }
}