package hu.advent.of.code.year2022.day9

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import kotlin.math.absoluteValue

@AdventOfCodePuzzle
class Puzzle9B: BaseChallenge(2022) {

    private val mapTail = mutableSetOf<Place>()
    private val knots = mutableListOf<Knot>()
    private val tail = Knot(0, 0)

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data9.txt")

        repeat(9) {
            knots.add(Knot(0, 0))
        }

        data.forEach {
            processCommand(it)
        }
        println("The tail visited ${mapTail.size} positions")

    }

    private fun processCommand(command: String) {
        val cmd = command.split(" ")
        when (cmd[0]) {
            "U" -> {
                repeat(cmd[1].toInt()) {
                    knots[0].up()
                    repeat(8) { knots[it+1].adjustPosition(knots[it]) }
                    tail.adjustPosition(knots.last())
                    mapTail.add(tail.self())
                }
            }

            "D" -> {
                repeat(cmd[1].toInt()) {
                    knots[0].down()
                    repeat(8) { knots[it+1].adjustPosition(knots[it]) }
                    tail.adjustPosition(knots.last())
                    mapTail.add(tail.self())
                }
            }

            "L" -> {
                repeat(cmd[1].toInt()) {
                    knots[0].left()
                    repeat(8) { knots[it+1].adjustPosition(knots[it]) }
                    tail.adjustPosition(knots.last())
                    mapTail.add(tail.self())
                }
            }

            else -> {
                repeat(cmd[1].toInt()) {
                    knots[0].right()
                    repeat(8) { knots[it+1].adjustPosition(knots[it]) }
                    tail.adjustPosition(knots.last())
                    mapTail.add(tail.self())
                }
            }
        }
    }
}

fun Knot.adjustPosition(mover: Knot) {

    when (mover.self() - this.self()) {
        Place(0,0) -> { /* Do nothing */}
        Place(2,2) -> { set(Place(mover.x - 1, mover.y - 1)) }
        Place(-2,2) -> { set(Place(mover.x + 1, mover.y - 1)) }
        Place(-2,-2) -> { set(Place(mover.x + 1, mover.y + 1)) }
        Place(2,-2) -> { set(Place(mover.x - 1, mover.y + 1)) }

        Place(1, 2), Place(-1, 2), Place(0, 2) -> { set( Place(mover.x, mover.y - 1) ) }
        Place(-1, -2), Place(1, -2), Place(0, -2) -> { set( Place(mover.x, mover.y + 1) ) }
        Place(-2, 1), Place(-2, -1), Place(-2, 0) -> { set( Place(mover.x + 1, mover.y) ) }
        Place(2, -1), Place(2, 1), Place(2, 0) -> { set( Place(mover.x - 1, mover.y) ) }
        else -> {
            val q = mover.self() - this.self()
            if( (q.x.absoluteValue + q.y.absoluteValue) > 2) {
                println(q)
            }

        }
    }
}