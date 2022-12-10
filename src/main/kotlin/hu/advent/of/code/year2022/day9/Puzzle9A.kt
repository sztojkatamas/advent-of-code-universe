package hu.advent.of.code.year2022.day9

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle9A: BaseChallenge(2022) {

    private val mapTail = mutableSetOf<Place>()
    private val head = Knot(0,0)
    private val tail = Knot(0,0)

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data9.txt")

        data.forEach {
            processCommand(it, head)
        }
        println("The tail visited ${mapTail.size} positions")
    }

    private fun adjustTail() : Place {

        when (head.self() - tail.self()) {
            Place(1,2) , Place(-1,2) , Place(0,2) -> { return Place(head.x, head.y-1) }
            Place(-1,-2) , Place(1,-2) , Place(0,-2) -> { return Place(head.x, head.y+1) }
            Place(-2,1) , Place(-2,-1) , Place(-2,0) -> { return Place(head.x+1, head.y) }
            Place(2,-1) , Place(2,1) , Place(2,0) -> { return Place(head.x-1, head.y) }
        }
        return tail.self()
    }

    private fun processCommand(command: String, head: Knot) {
        val cmd = command.split(" ")
        when (cmd[0]) {
            "U" -> {
                repeat(cmd[1].toInt()) {
                    head.up()
                    tail.set(adjustTail())
                    mapTail.add(tail.self())
                }
            }
            "D" -> {
                repeat(cmd[1].toInt()) {
                    head.down()
                    tail.set(adjustTail())
                    mapTail.add(tail.self())
                }
            }
            "L" -> {
                repeat(cmd[1].toInt()) {
                    head.left()
                    tail.set(adjustTail())
                    mapTail.add(tail.self())
                }
            }
            else -> {
                repeat(cmd[1].toInt()) {
                    head.right()
                    tail.set(adjustTail())
                    mapTail.add(tail.self())
                }
            }
        }
    }
}

