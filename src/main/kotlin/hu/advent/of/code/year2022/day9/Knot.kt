package hu.advent.of.code.year2022.day9

class Knot(var x: Int, var y: Int) {
    fun up(): Place {
        return Place(x, y++)
    }
    fun down(): Place {
        return Place(x, y--)
    }
    fun left(): Place {
        return Place(x--, y)
    }
    fun right(): Place {
        return Place(x++, y)
    }
    fun self(): Place {
        return Place(x, y)
    }

    fun set(value: Place) {
        x = value.x
        y = value.y
    }

    override fun toString(): String {
        return "($x,$y)"
    }
}