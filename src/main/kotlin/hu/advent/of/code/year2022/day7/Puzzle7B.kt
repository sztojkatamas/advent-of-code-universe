package hu.advent.of.code.year2022.day7

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle7B: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data7.txt")
        val root = buildFileSystem(data)

        val totalDisk = 70000000
        val free = totalDisk - root.find { it.path == "/" }!!.getSizeOnDisk()
        root.filter { it.directory }.sortedBy { it.getSizeOnDisk() }.forEach {
            if((root.getDirSize(it.path) + free) > 30000000) {
                println("Need to delete directory: ${it.path} \nsize: ${it.getSizeOnDisk()}")
                return
            }
        }
    }
}