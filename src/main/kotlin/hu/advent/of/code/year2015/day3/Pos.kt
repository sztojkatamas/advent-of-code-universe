package hu.advent.of.code.year2015.day3

class Pos(var x:Int, var y:Int) {

    fun right() { x++ }
    fun left() { x-- }
    fun up() { y++ }
    fun down() { y-- }

    fun getPosString():String { return "$x-$y" }

}