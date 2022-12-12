package hu.advent.of.code.year2022.day12

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import java.util.PriorityQueue

@AdventOfCodePuzzle
class Puzzle12B: BaseChallenge(2022) {
    override fun run() {
        printPuzzleName()
        loadDataFromFile("data12.txt")

        val world = generateWorld(data)
        val navigationMap = createNavigationMap(world)
        val states = PriorityQueue<GameState>()

        world.cellMap.filter { it.value.elevation == 'a' }.map {
            states.add(GameState(it.key, emptyList()))
        }

        val steps = calculatePath(states, world.end, navigationMap)
        println("Fewest steps backwards: $steps")
    }
}