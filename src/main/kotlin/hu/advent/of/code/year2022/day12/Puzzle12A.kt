package hu.advent.of.code.year2022.day12

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import java.util.PriorityQueue

@AdventOfCodePuzzle
class Puzzle12A: BaseChallenge(2022) {
    override fun run() {
        printPuzzleName()
        loadDataFromFile("data12.txt")

        val world = generateWorld(data)
        val navigationMap = createNavigationMap(world)
        val states = PriorityQueue<GameState>()

        states.add(GameState(world.start, emptyList()))
        val steps = calculatePath(states, world.end, navigationMap)
        println("Fewest steps: $steps")
    }
}

fun calculatePath(
    states: PriorityQueue<GameState>,
    end: Pos2D,
    navigationMap: Map<Pos2D, CellWithOther>
): Int {
    val visitedPositions = mutableSetOf<Pos2D>()
    val costs: Int
    while (true) {
        val first = states.first()

        if (first.pos == end) {
            costs = first.path.size
            break
        }

        states.remove(first)
        for ((k, n) in navigationMap.getValue(first.pos).directionToOthers) {
            if (!visitedPositions.contains(n.pos)) {
                states.add(GameState(n.pos, first.path + k))
                visitedPositions.add(n.pos)
            }
        }
    }
    return costs
}
fun createNavigationMap(world: World): Map<Pos2D, CellWithOther> {
    val navigationMap = mutableMapOf<Pos2D, CellWithOther>()
    world.cellMap.forEach { (_, cell) ->
        val directions = Direction.ALL.mapNotNull {
            val next = world.cellMap[cell.pos + it]
            if (next == null || next.elevation > (cell.elevation + 1)) {
                null
            } else {
                it to next
            }
        }.toMap()
        navigationMap[cell.pos] = CellWithOther(cell, directions)
    }
    return navigationMap
}

fun generateWorld(lines: List<String>): World {
    val map = mutableMapOf<Pos2D, Cell>()
    var startPos = Pos2D(0,0)
    var endPos = Pos2D(0,0)

    lines.forEachIndexed { y, line ->
        line.forEachIndexed { x, column ->
            val currentPos = Pos2D(x, y)
            val elevation = when (column) {
                'S' -> {
                    startPos = currentPos
                    'a'
                }
                'E' -> {
                    endPos = currentPos
                    'z'
                }
                else -> { column }
            }
            map[currentPos] = Cell(currentPos, elevation)
        }
    }
    return World(startPos, endPos, map)
}

class GameState(val pos: Pos2D, val path: List<Pos2D>): Comparable<GameState> {
    override fun compareTo(other: GameState): Int {
        return path.size - other.path.size
    }
}

data class World(val start: Pos2D, val end: Pos2D, val cellMap: Map<Pos2D, Cell>)

data class CellWithOther(val cell: Cell, val directionToOthers: Map<Pos2D, Cell>)
data class Cell(val pos: Pos2D, val elevation: Char)
data class Pos2D(val x: Int, val y: Int) {
    operator fun plus(other: Pos2D): Pos2D {
        return Pos2D(this.x + other.x, this.y + other.y)
    }
}

object Direction {
    private val UP = Pos2D(0, -1)
    private val DOWN = Pos2D(0, 1)
    private val LEFT = Pos2D(-1, 0)
    private val RIGHT = Pos2D(1, 0)

    val ALL = listOf(LEFT, UP, RIGHT, DOWN)
}