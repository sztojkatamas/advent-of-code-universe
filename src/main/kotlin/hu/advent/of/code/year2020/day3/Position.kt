package hu.advent.of.code.year2020.day3

data class Position(var x:Int, var y:Int) {

    override fun toString(): String {
        return "($x,$y)"
    }
}