package hu.advent.of.code.year2020.day3

object Maputils {

    fun expandMap(map:List<String>, factor :Int) : MutableList<String> {
        val retMap = mutableListOf<String>()
        for (i in map) {
            var expandedline = ""
            for (x in 1..factor) {
                expandedline += i
            }
            retMap.add(expandedline)
        }

        return retMap
    }

    fun mark(map: MutableList<String>, position: Position) : Boolean{

        val s = map[position.y].toCharArray()
        var marker = 'O'
        if(s[position.x].equals('#')) {
            marker = 'X'
        }
        s[position.x] = marker
        map[position.y] = s.concatToString()

        return marker.equals('X')
    }


}