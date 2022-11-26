package hu.advent.of.code

import java.util.Scanner

abstract class BaseChallenge(private val year: Int) {

    var data = mutableListOf<String>()

    open fun run() {
        // To be overwritten
    }

    open fun loadDataFromFile(filename: String) {
        val scanner = Scanner(this::class.java.getResourceAsStream("/$year/$filename")!!)
        while (scanner.hasNextLine()) {
            data.add(scanner.nextLine())
        }
    }

    open fun loadIntDataFromFile(filename: String) : List<Int> {
        val intData = mutableListOf<Int>()
        loadDataFromFile(filename)
        data.forEach { intData.add(it.toInt()) }
        return intData
    }

    open fun loadLongDataFromFile(filename: String): List<Long> {
        val longData = mutableListOf<Long>()
        loadDataFromFile(filename)
        data.forEach { longData.add(it.toLong()) }
        return longData
    }

    fun printPuzzleName() {
        val puzzleClassName = this.javaClass.simpleName
        val dayAndNum = puzzleClassName.drop(6) // Drop "Puzzle"
        val num = when(dayAndNum.last().lowercase()) {
            "a" -> 1
            else ->2
        }
        println("\n$year [ Day ${dayAndNum.dropLast(1)} - Puzzle $num ]")
    }
}