package hu.advent.of.code.year2017.day3

class Pos(var x :Int, var y :Int) {

    var lastHeading: Direction = Direction.SOUTH

    fun east() : Pos {
        x++
        lastHeading = Direction.EAST
        return this
    }

    fun west() : Pos {
        x--
        lastHeading = Direction.WEST
        return this
    }

    fun north() : Pos {
        y++
        lastHeading = Direction.NORTH
        return this
    }

    fun south() : Pos {
        y--
        lastHeading = Direction.SOUTH
        return this
    }

    fun where() :Pos {
        return Pos(x, y)
    }

    override fun toString() : String {
        return "${x}x${y}"
    }
}
