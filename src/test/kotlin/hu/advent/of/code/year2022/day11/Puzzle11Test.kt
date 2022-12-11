package hu.advent.of.code.year2022.day11

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle11Test {

   private val data = """
Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3

Monkey 1:
  Starting items: 54, 65, 75, 74
  Operation: new = old + 6
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 0

Monkey 2:
  Starting items: 79, 60, 97
  Operation: new = old * old
  Test: divisible by 13
    If true: throw to monkey 1
    If false: throw to monkey 3

Monkey 3:
  Starting items: 74
  Operation: new = old + 3
  Test: divisible by 17
    If true: throw to monkey 0
    If false: throw to monkey 1"""

        @Test
        fun `basic monkey tests`() {
                val monkeys = buildMonkeys(data.split("\n"))
                assertEquals(4, monkeys.size)
                assertEquals("monkey 3", monkeys[3].name)
                assertEquals(60.0, monkeys[2].items[1])
                assertEquals(97.0, monkeys[2].items[2])
                assertEquals(13.0, monkeys[2].divBy)
                assertEquals("monkey 1", monkeys[2].trueMonkey)
                assertEquals("monkey 3", monkeys[2].falseMonkey)
                assertEquals(17.0, monkeys.getMonkey(monkeys[0].falseMonkey).divBy)
                assertEquals(13.0, monkeys[3].changeWorryLevel(10.0))
                assertEquals(100.0, monkeys[2].changeWorryLevel(10.0))
        }

        @Test
        fun `monkey business with calming`() {
                val monkeys = buildMonkeys(data.split("\n"))
                // Start
                assertEquals(mutableListOf(79.0, 98.0), monkeys[0].items)
                assertEquals(mutableListOf(54.0, 65.0, 75.0, 74.0), monkeys[1].items)
                assertEquals(mutableListOf(79.0, 60.0, 97.0), monkeys[2].items)
                assertEquals(mutableListOf(74.0), monkeys[3].items)

                monkeys.doTheMonkeyBusiness(true)
                assertEquals(mutableListOf(20.0, 23.0, 27.0, 26.0), monkeys[0].items)
                assertEquals(mutableListOf(2080.0, 25.0, 167.0, 207.0, 401.0, 1046.0), monkeys[1].items)
                assertEquals(emptyList<Double>().toMutableList(), monkeys[2].items)
                assertEquals(emptyList<Double>().toMutableList(), monkeys[3].items)

                monkeys.doTheMonkeyBusiness(true)
                assertEquals(mutableListOf(695.0, 10.0, 71.0, 135.0, 350.0), monkeys[0].items)
                assertEquals(mutableListOf(43.0, 49.0, 58.0, 55.0, 362.0), monkeys[1].items)
                assertEquals(emptyList<Double>().toMutableList(), monkeys[2].items)
                assertEquals(emptyList<Double>().toMutableList(), monkeys[3].items)

                repeat(18) { monkeys.doTheMonkeyBusiness(true) }

                assertEquals(mutableListOf(10.0, 12.0, 14.0, 26.0, 34.0), monkeys[0].items)
                assertEquals(mutableListOf(245.0, 93.0, 53.0, 199.0, 115.0), monkeys[1].items)
                assertEquals(emptyList<Double>().toMutableList(), monkeys[2].items)
                assertEquals(emptyList<Double>().toMutableList(), monkeys[3].items)

                val mm = monkeys.sortedByDescending { it.inspection }
                assertEquals(10605, mm[0].inspection * mm[1].inspection)
        }

        @Test
        fun `monkey business without calming`() {
                val monkeys = buildMonkeys(data.split("\n"))
                repeat(10000) { monkeys.doTheMonkeyBusiness(false) }

                val mm = monkeys.sortedByDescending { it.inspection }
                assertEquals(2713310158, mm[0].inspection.times(mm[1].inspection))
        }
}