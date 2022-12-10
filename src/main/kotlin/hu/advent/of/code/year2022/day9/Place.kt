package hu.advent.of.code.year2022.day9

class Place(var x: Int, var y: Int) {
    override fun equals(other: Any?): Boolean {
        other as Place
        return this.x == other.x && this.y == other.y
    }
    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    operator fun minus(other: Place): Place {
        return Place(x - other.x, y - other.y)
    }

    override fun toString(): String {
        return "($x,$y)"
    }
}
