package hu.advent.of.code.year2022.day7

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle7ATest {

    @Test
    fun `testing on Santa's mini drive`() {
        val termOutput = mutableListOf("$ cd /",
            "$ ls",
            "dir a",
            "14848514 b.txt",
            "8504156 c.dat",
            "dir d",
            "$ cd a",
            "$ ls",
            "dir e",
            "29116 f",
            "2557 g",
            "62596 h.lst",
            "$ cd e",
            "$ ls",
            "584 i",
            "$ cd ..",
            "$ cd ..",
            "$ cd d",
            "$ ls",
            "4060174 j",
            "8033020 d.log",
            "5626152 d.ext",
            "7214296 k")
        val root = buildFileSystem(termOutput)
        assertEquals(584, root.getDirSize("/a/e"))
        assertEquals(94853, root.getDirSize("/a/"))
        assertEquals(24933642, root.getDirSize("/d/"))
        assertEquals(95437, root.filter { it.directory && root.getDirSize(it.path) < 100000 }.sumOf { root.getDirSize(it.path) })
    }
}