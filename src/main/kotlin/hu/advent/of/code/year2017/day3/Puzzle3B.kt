package hu.advent.of.code.year2017.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import kotlin.math.absoluteValue
import kotlin.system.measureTimeMillis

@AdventOfCodePuzzle
class Puzzle3B: BaseChallenge(2017) {

    private val map = mutableMapOf<Pos, Int>()
    private val cache = mutableSetOf<String>()
    private val place = Pos(0,0)
    private var prevHeading = Direction.SOUTH
    private var lastValue = 0

    override fun run() {
        printPuzzleName()
        val sqNum = loadIntDataFromFile("data3.txt")[0]

        map[place.where()] = 1
        cache.add(place.toString())

        println("Generated in ${measureTimeMillis { generate( sqNum) }} ms")
        println("Advanced spiral overflow: $lastValue")
    }

    private fun generate(ceiling :Int) {
        while (lastValue <= ceiling) {
            prevHeading = when (prevHeading) {
                Direction.SOUTH -> {
                    if (isPlaceEmpty(place.where().east().where())) {
                        goDirection(Direction.EAST, place)
                    } else {
                        goDirection(Direction.SOUTH, place)
                    }
                }

                Direction.EAST -> {
                    if (isPlaceEmpty(place.where().north().where())) {
                        goDirection(Direction.NORTH, place)
                    } else {
                        goDirection(Direction.EAST, place)
                    }
                }

                Direction.NORTH -> {
                    if (isPlaceEmpty(place.where().west().where())) {
                        goDirection(Direction.WEST, place)
                    } else {
                        goDirection(Direction.NORTH, place)
                    }
                }

                else -> {
                    if (isPlaceEmpty(place.where().south().where())) {
                        goDirection(Direction.SOUTH, place)
                    } else {
                        goDirection(Direction.WEST, place)
                    }
                }
            }
            lastValue = getValueByPosition(place.where())
        }
    }

    private fun getValueByPosition(position: Pos): Int {
        val p = map.keys.find {it.x == position.x && it.y == position.y}
        val o = map[p]
        return when (o) {
            null -> 0
            else -> o
        }
    }

    private fun goDirection(where :Direction, place :Pos) : Direction {
        when(where) {
            Direction.NORTH -> { place.north() }
            Direction.EAST -> { place.east() }
            Direction.WEST -> { place.west() }
            else -> { place.south()}
        }
        map[place.where()] = getSumAroundPlace(place.where())
        cache.add(place.toString())
        return place.lastHeading
    }

    private fun isPlaceEmpty(p: Pos) : Boolean {
        return !cache.contains(p.toString())
    }

    private fun getSumAroundPlace(p :Pos) : Int {
        val here = p
        var sum = 0
        sum += getValueByPosition(here.east())
        sum += getValueByPosition(here.north())
        sum += getValueByPosition(here.west())
        sum += getValueByPosition(here.west())
        sum += getValueByPosition(here.south())
        sum += getValueByPosition(here.south())
        sum += getValueByPosition(here.east())
        sum += getValueByPosition(here.east())
        return sum
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