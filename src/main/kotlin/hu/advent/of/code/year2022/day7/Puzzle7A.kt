package hu.advent.of.code.year2022.day7

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge

@AdventOfCodePuzzle
class Puzzle7A: BaseChallenge(2022) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data7.txt")
        val root = buildFileSystem(data)
        println("Total size of directories under 100000 bytes: ${root.filter { it.directory && it.getSizeOnDisk() < 100000 }.sumOf { it.getSizeOnDisk() }}")
    }
}

fun buildFileSystem(terminalOutput: List<String>): MutableSet<SantaFS> {
    val fs = mutableSetOf<SantaFS>()
    var currentPath = ""
    terminalOutput.forEach {
        when {
            it == "$ cd .." -> {
                currentPath = currentPath.dropLastDir()
            }
            it.startsWith("$ cd") -> {
                currentPath += it.split(" ")[2]
                if (currentPath.last() != '/') {
                    currentPath += "/"
                }
                fs.add(SantaDir(currentPath, fs))
            }
            it.startsWith("$ ls") -> { /* Nothing to do */ }
            it.startsWith("dir") -> { /* Nothing to do */ }
            else -> { // This is the file
                val fd = it.split(" ")
                fs.add(SantaFile("$currentPath${fd[1]}", fd[0].toInt()))
            }
        }
    }
    return fs
}
fun String.dropLastDir(): String {
    val last = this.dropLast(1).split("/").last().length
    return  this.dropLast(last+1)
}
fun Set<SantaFS>.getDirSize(path: String): Int {
    return this.filter { !it.directory && it.path.startsWith(path) }.sumOf { it.getSizeOnDisk() }
}


class SantaDir(override val path: String, private val fileSystem: Set<SantaFS>): SantaFS {
    override val directory = true

    override fun getSizeOnDisk(): Int {
        return fileSystem.getDirSize(path)
    }
}

class SantaFile(override val path: String, val size: Int): SantaFS {
    override val directory = false

    override fun getSizeOnDisk(): Int {
        return size
    }
}

interface SantaFS {
    val path: String
    val directory: Boolean
    fun getSizeOnDisk(): Int
}