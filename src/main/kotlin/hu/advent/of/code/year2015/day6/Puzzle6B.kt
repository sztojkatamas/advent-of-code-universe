package hu.advent.of.code.year2015.day6

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle6B:BaseChallenge(2015) {

    var lamps = mutableMapOf<String, AdvancedLamp>()
    var lampsWith = 0
    var lampsHeight = 0

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data6.txt")
        initLamps(1000, 1000)
        data.forEach {
            val splitLine = it.split(" ")
            when (splitLine[0]) {
                "toggle" -> processRegion(splitLine[1].replace(",", "-"), splitLine[3].replace(",", "-"), "toggle")
                "turn" -> processRegion(splitLine[2].replace(",", "-"), splitLine[4].replace(",", "-"), splitLine[1])
            }
        }

        println("Lightlevel: ${countBrightnessOfTheLamps()}")
    }

    fun initLamps(x: Int, y: Int) {
        lampsWith = x
        lampsHeight = y
        repeat(x) { row ->
            repeat(y) { col ->
                lamps["$row-$col"] = AdvancedLamp("$row-$col", 0)
            }
        }
    }

    fun getLamp(key: String): AdvancedLamp {
        return lamps.get(key)!!
    }

    fun toggleLamp(key: String) {
        val lamp = getLamp(key)
        lamp.level = lamp.level + 2
    }

    fun countBrightnessOfTheLamps(): Int {
        var brightness = 0
        lamps.forEach { brightness += it.value.level}
        return brightness
    }

    fun switchOnLamp(key: String) {
        getLamp(key).level++
    }

    fun switchOffLamp(key: String) {
        if (getLamp(key).level > 0) {
            getLamp(key).level--
        }
    }

    fun processRegion(key1: String, key2: String, command: String) {
        val x1 = key1.split("-")[0].toInt()
        val y1 = key1.split("-")[1].toInt()
        val x2 = key2.split("-")[0].toInt()
        val y2 = key2.split("-")[1].toInt()

        val a1 = x1.coerceAtMost(x2)
        val b1 = x1.coerceAtLeast(x2)
        val a2 = y1.coerceAtMost(y2)
        val b2 = y1.coerceAtLeast(y2)

        for (x in a1..b1) {
            for (y in a2..b2) {
                //println("$x-$y")
                when (command) {
                    "on" -> switchOnLamp("$x-$y")
                    "off" -> switchOffLamp("$x-$y")
                    "toggle" -> toggleLamp("$x-$y")
                }
            }
        }
    }
}

data class AdvancedLamp(val name: String, var level: Int)
