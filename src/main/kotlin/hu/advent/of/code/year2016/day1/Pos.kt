package hu.advent.of.code.year2016.day1

import kotlin.math.absoluteValue

class Pos(var x :Int, var y :Int) {
    var facing = Direction.NORTH
    val visitedPlaces = mutableSetOf<String>()
    var found = false

    fun turnLeft() {
        facing = when(facing) {
            Direction.NORTH -> Direction.WEST
            Direction.WEST -> Direction.SOUTH
            Direction.SOUTH -> Direction.EAST
            else -> Direction.NORTH
        }
    }

    fun turnRight() {
        facing = when(facing) {
            Direction.NORTH -> Direction.EAST
            Direction.EAST -> Direction.SOUTH
            Direction.SOUTH -> Direction.WEST
            else -> Direction.NORTH
        }
    }
    fun walk(steps :Int) {
        repeat(steps) {
            when (facing) {
                Direction.NORTH -> north()
                Direction.EAST -> east()
                Direction.SOUTH -> south()
                else -> west()
            }
            if (!visitedPlaces.add(this.toString()) && !found) {
                println("Easter Bunny REAL HQ is ${this.x.absoluteValue + this.y.absoluteValue} blocks away")
                found = true
            }

        }
    }

    fun east() : Pos {
        x++
        return this
    }

    fun west() : Pos {
        x--
        return this
    }

    fun north() : Pos {
        y++
        return this
    }

    fun south() : Pos {
        y--
        return this
    }

    override fun toString() : String {
        return "${x}x${y}"
    }
}