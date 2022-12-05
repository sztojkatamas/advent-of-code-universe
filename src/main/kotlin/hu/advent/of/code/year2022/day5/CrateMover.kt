package hu.advent.of.code.year2022.day5

import java.util.*

object CrateMover {
    fun getTopCrates(cols :Int, stack :Map<Int, Stack<Char>>): String{
        var result = ""
        repeat(cols) {
            result += stack[it+1]!!.pop()
        }
        return result
    }

    fun getHeader(paper: MutableList<String>): List<String> {
        var c = 0
        val paddedHead = mutableListOf<String>()

        paper.forEachIndexed { idx, row ->
            if (row.isEmpty()) { c = idx }
        }
        val padLength = paper.take(c).maxBy { it.length }.length
        paper.take(c).forEach {
            paddedHead.add(it.padEnd(padLength, ' '))
        }
        return paddedHead
    }

    fun getNumberOfStacks(lastHeaderLine :String): Int {
        return lastHeaderLine.split(" ").count { it.isNotEmpty() }
    }
    fun getMoves(data: MutableList<String>): List<String> {
        data.forEachIndexed { idx, row ->
            if (row.isEmpty()) { return data.takeLast(data.size - idx-1) }
        }
        return emptyList()
    }

    fun initStacks(size :Int): Map<Int, Stack<Char>> {
        val stackMap = mutableMapOf<Int, Stack<Char>>()
        repeat(size) {
            stackMap[it+1] = Stack<Char>()
        }
        return stackMap
    }
}

fun Map<Int, Stack<Char>>.populateStacks(header: List<String>, cols :Int) {
    repeat(header.size - 1) { lineNumber ->
        val line = header[header.size - 2 - lineNumber]
        repeat(cols) {
            when (it) {
                0 -> this[1]!!.push(line[1])
                else -> this[it + 1]!!.push(line[it * 4 + 1])
            }
        }
    }
    this.forEach { stackEntry -> stackEntry.value.removeIf {it == ' '} }
}

fun Map<Int, Stack<Char>>.moveCrates9000(mvs: List<String>) {
    mvs.forEach {
        val command = it.split(" ")
        repeat(command[1].toInt()) {
            this[command[5].toInt()]!!.push(this[command[3].toInt()]!!.pop())
        }
    }
}

fun Map<Int, Stack<Char>>.moveCrates9001(moves: List<String>) {
    moves.forEach { commandLine ->
        val command = commandLine.split(" ")
        val res = mutableListOf<Char>()

        repeat(command[1].toInt()) {
            res.add(this[command[3].toInt()]!!.pop())
        }
        res.reverse()
        res.forEach {
            this[command[5].toInt()]!!.push(it)
        }

    }
}