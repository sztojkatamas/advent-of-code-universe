package hu.advent.of.code.year2022.day11

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import kotlin.math.floor

@AdventOfCodePuzzle
class Puzzle11A: BaseChallenge(2022) {
    override fun run() {
        printPuzzleName()
        loadDataFromFile("data11.txt")

        val monkeys = buildMonkeys(data)
        repeat(20) { monkeys.doTheMonkeyBusiness(true) }
        val mm = monkeys.sortedByDescending { it.inspection }
        println("Level of monkey business wih calming: ${mm[0].inspection * mm[1].inspection}")

    }
}

fun buildMonkeys(input: List<String>): List<Monkey> {
    val monkeyList = mutableListOf<Monkey>()
    input.forEachIndexed { index, s ->
        if (s.startsWith("Monkey")) {
            val cheeta = Monkey(s.lowercase().dropLast(1))
            monkeyList.add(cheeta)

            val items = input[index+1].split(":")[1].trim().split(", ")
            items.forEach { cheeta.addItem(it.toDouble()) }

            cheeta.operand = input[index+2].split("= old ")[1].split(" ")
            cheeta.divBy = input[index+3].split(" ").last().toDouble()
            cheeta.trueMonkey = input[index+4].split(" to ")[1].lowercase()
            cheeta.falseMonkey = input[index+5].split(" to ")[1].lowercase()
        }
    }
    return monkeyList
}
fun List<Monkey>.getMonkey(name: String): Monkey {
    return this.find { it.name == name.lowercase() }!!
}
fun List<Monkey>.doTheMonkeyBusiness(calmDown: Boolean) {
    var supermod = 1.0
    this.forEach { supermod *= it.divBy }

    this.forEachIndexed { _, monkey ->

        monkey.items.forEachIndexed { _, it ->
            var x = monkey.changeWorryLevel(it)
            if (calmDown) {
                //x /= 3
                x = floor(x/3)
            } else {
                x %= supermod
            }
            if (x.mod(monkey.divBy) == 0.0) {
                this.getMonkey(monkey.trueMonkey).items.add(x)
            } else {
                this.getMonkey(monkey.falseMonkey).items.add(x)
            }
        }
        monkey.inspection += monkey.items.count().toLong()
        monkey.items.clear()
    }
}

class Monkey(val name: String) {
    val items = mutableListOf<Double>()
    var operand = listOf<String>()
    var divBy = 0.0
    var trueMonkey = ""
    var falseMonkey = ""
    var inspection = 0L

    fun addItem(item: Double) {
        items.add(item)
    }

    fun changeWorryLevel(input: Double): Double {
        val op2 = when (operand[1]) {
            "old" -> input
            else -> operand[1].toDouble()
        }
        return when (operand[0]) {
            "+" -> input.plus(op2)
            "*" -> input.times(op2)
            else -> { -1000.0 }
        }
    }
}
