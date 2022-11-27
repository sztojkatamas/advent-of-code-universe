package hu.advent.of.code.year2017.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import kotlin.math.absoluteValue
import kotlin.system.measureTimeMillis

@AdventOfCodePuzzle
class Puzzle3A: BaseChallenge(2017) {

    private val map = mutableMapOf<Pos, Int>()
    private val cache = mutableSetOf<String>()
    private val place = Pos(0,0)
    var prevHeading = Direction.SOUTH

    override fun run() {
        printPuzzleName()
        val sqNum = loadIntDataFromFile("data3.txt")[0]

        map[place.where()] = 1
        cache.add(place.toString())

        println("Generated in ${measureTimeMillis { generate( sqNum + 1) }} ms")
        val q = getPlace(sqNum)
        println("Spiral Memory steps: ${q.x.absoluteValue + q.y.absoluteValue}")
    }

    private fun generate(ceiling :Int) {
        repeat(ceiling) { x ->
            val it = x+2
            prevHeading = when (prevHeading) {
                Direction.SOUTH -> {
                    if (isPlaceEmpty(place.where().east().where())) {
                        goDirection(Direction.EAST, place, it)
                    } else {
                        goDirection(Direction.SOUTH, place, it)
                    }
                }
                Direction.EAST -> {
                    if (isPlaceEmpty(place.where().north().where())) {
                        goDirection(Direction.NORTH, place, it)
                    } else {
                        goDirection(Direction.EAST, place, it)
                    }
                }
                Direction.NORTH -> {
                    if (isPlaceEmpty(place.where().west().where())) {
                        goDirection(Direction.WEST, place, it)
                    } else {
                        goDirection(Direction.NORTH, place, it)
                    }
                }
                else -> {
                    if (isPlaceEmpty(place.where().south().where())) {
                        goDirection(Direction.SOUTH, place, it)
                    } else {
                        goDirection(Direction.WEST, place, it)
                    }
                }
            }
        }

    }

    private fun goDirection(where :Direction, place :Pos, num :Int) : Direction {
        when(where) {
            Direction.NORTH -> { place.north() }
            Direction.EAST -> { place.east() }
            Direction.WEST -> { place.west() }
            else -> { place.south()}
        }
        map[place.where()] = num
        cache.add(place.toString())
        return place.lastHeading
    }

    private fun isPlaceEmpty(p: Pos) : Boolean {
        return !cache.contains(p.toString())
    }

    private fun getPlace(value :Int) : Pos {
        return map.filter { it.value == value }.keys.first()
    }

    private fun printMap() {
        val maxX = map.maxBy { it.key.x }.key.x
        val minX = map.minBy { it.key.x }.key.x
        val maxY = map.maxBy { it.key.y }.key.y
        val minY = map.minBy { it.key.y }.key.y
        repeat(maxY.absoluteValue + minY.absoluteValue + 1) { y ->
            repeat(maxX.absoluteValue + minX.absoluteValue + 1) { x ->
                val p = map.keys.find {it.x == (minX + x) && it.y == (maxY - y)}
                val o = map[p]

                when (o) {
                    null -> print(" [  -   ]")
                    else -> print(" [$o (${p?.x} - ${p?.y})]")
                }
            }
            println()
        }
    }

}