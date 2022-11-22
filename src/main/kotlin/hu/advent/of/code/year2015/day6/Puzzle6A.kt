package hu.advent.of.code.year2015.day6

import hu.advent.of.code.BaseChallenge

class Puzzle6A:BaseChallenge(2015) {

    var lamps = mutableMapOf<String, Lamp>()
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

        println("Lights on: ${countBrightLamps()}")
    }

    fun initLamps(x: Int, y: Int) {
        lampsWith = x
        lampsHeight = y
        repeat(x) { row ->
            repeat(y) { col ->
                lamps["$row-$col"] = Lamp("$row-$col", false)
            }
        }
    }

    fun getLamp(key: String): Lamp {
        return lamps.get(key)!!
    }

    fun toggleLamp(key: String) {
        val lamp = getLamp(key)
        lamp.working = !lamp.working
    }

    fun countBrightLamps(): Int {
        return  lamps.values.parallelStream().filter { it.working }.count().toInt()
    }

    fun switchOnLamp(key: String) {
        getLamp(key).working = true
    }

    fun switchOffLamp(key: String) {
        getLamp(key).working = false
    }

    fun toggleLamps(corner1: String, corner2: String) {
        processRegion(corner1, corner2, "toggle")
    }

    fun processRegion(key1: String, key2: String, command: String) {
        val x1 = key1.split("-")[0].toInt()
        val y1 = key1.split("-")[1].toInt()
        val x2 = key2.split("-")[0].toInt()
        val y2 = key2.split("-")[1].toInt()

        //println("$x1 $y1 $x2 $y2  ")

        val a1 = x1.coerceAtMost(x2)
        val b1 = x1.coerceAtLeast(x2)
        val a2 = y1.coerceAtMost(y2)
        val b2 = y1.coerceAtLeast(y2)

        //println("[$command] $x1 $y1 $x2 $y2     ->     $a1 $a2 $b1 $b2")

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
        //println("$a1 $a2 $b1 $b2")
    }

    fun switchOnLamps(corner1: String, corner2: String) {
        processRegion(corner1, corner2, "on")
    }

    fun switchOffLamps(corner1: String, corner2: String) {
        processRegion(corner1, corner2, "off")
    }
}

data class Lamp(val name: String, var working: Boolean)
