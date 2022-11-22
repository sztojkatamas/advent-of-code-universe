package hu.advent.of.code

class Application {
    fun runAll() {

        val puzzles2015 = listOf(
            hu.advent.of.code.year2015.day1.Puzzle1A(),
            hu.advent.of.code.year2015.day1.Puzzle1B(),
            hu.advent.of.code.year2015.day2.Puzzle2A(),
            hu.advent.of.code.year2015.day2.Puzzle2B(),
            hu.advent.of.code.year2015.day3.Puzzle3A(),
            hu.advent.of.code.year2015.day3.Puzzle3B(),
            hu.advent.of.code.year2015.day4.Puzzle4A(),
            hu.advent.of.code.year2015.day4.Puzzle4B(),
            hu.advent.of.code.year2015.day5.Puzzle5A(),
            hu.advent.of.code.year2015.day5.Puzzle5B(),
            hu.advent.of.code.year2015.day6.Puzzle6A(),
            hu.advent.of.code.year2015.day6.Puzzle6B()
        )

        val puzzles2019 = listOf(
            hu.advent.of.code.year2019.day1.Puzzle1A(),
            hu.advent.of.code.year2019.day1.Puzzle1B(),
            hu.advent.of.code.year2019.day2.Puzzle2A(),
            hu.advent.of.code.year2019.day2.Puzzle2B(),
            hu.advent.of.code.year2019.day3.Puzzle3A()
        )

        val puzzles2020 = listOf(
            hu.advent.of.code.year2020.day1.Puzzle1A(),
            hu.advent.of.code.year2020.day1.Puzzle1B(),
            hu.advent.of.code.year2020.day2.Puzzle2A(),
            hu.advent.of.code.year2020.day2.Puzzle2B(),
            hu.advent.of.code.year2020.day3.Puzzle3A(),
            hu.advent.of.code.year2020.day3.Puzzle3B(),
            hu.advent.of.code.year2020.day4.Puzzle4A(),
            hu.advent.of.code.year2020.day4.Puzzle4B(),
            hu.advent.of.code.year2020.day5.Puzzle5A(),
            hu.advent.of.code.year2020.day5.Puzzle5B(),
            hu.advent.of.code.year2020.day6.Puzzle6A(),
            hu.advent.of.code.year2020.day6.Puzzle6B(),
            hu.advent.of.code.year2020.day7.Puzzle7A(),
            hu.advent.of.code.year2020.day7.Puzzle7B(),
            hu.advent.of.code.year2020.day8.Puzzle8A(),
            hu.advent.of.code.year2020.day8.Puzzle8B(),
            hu.advent.of.code.year2020.day9.Puzzle9A(),
            hu.advent.of.code.year2020.day9.Puzzle9B(),
            hu.advent.of.code.year2020.day10.Puzzle10A(),
            hu.advent.of.code.year2020.day10.Puzzle10B()
        )

        val puzzles2021 = listOf(
            hu.advent.of.code.year2021.day1.Puzzle1A(),
            hu.advent.of.code.year2021.day1.Puzzle1B(),
            hu.advent.of.code.year2021.day2.Puzzle2A(),
            hu.advent.of.code.year2021.day2.Puzzle2B(),
            hu.advent.of.code.year2021.day3.Puzzle3A(),
            hu.advent.of.code.year2021.day3.Puzzle3B()
        )

//        puzzles2015.forEach { it.run() }
//        puzzles2019.forEach { it.run() }
        puzzles2020.forEach { it.run() }
//        puzzles2021.forEach { it.run() }
    }
}

fun main() {
    Application().runAll()
}
