package hu.advent.of.code.year2015.day5

import hu.advent.of.code.year2015.day5.Puzzle5B
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.concurrent.thread

class Puzzle5BTest {

    @Test
    fun testHasDoublesWithGap() {
        val puzzle = Puzzle5B()
        assertTrue(puzzle.hasDoublesWithGap("aba"))
        assertTrue(puzzle.hasDoublesWithGap("abab"))
        assertTrue(puzzle.hasDoublesWithGap("babab"))
        assertTrue(puzzle.hasDoublesWithGap("qjhvhtzxzqqjkmpb"))
        assertFalse(puzzle.hasDoublesWithGap("aa"))
    }

    @Test
    fun testPairsMoreThanOnceButNotOverlapped() {
        val puzzle = Puzzle5B()
        assertTrue(puzzle.hasNonOverlappingPairs("abxxab"))
        assertTrue(puzzle.hasNonOverlappingPairs("xyxy"))
        assertTrue(puzzle.hasNonOverlappingPairs("aabcdefgaa"))
        assertFalse(puzzle.hasNonOverlappingPairs("aaa"))
    }

    lateinit var map:MutableMap<String, Thread>

    @Test
    fun cctest() {
        map = mutableMapOf<String, Thread>()

        for (i in 1..3000) {
            map.put("XXX-$i", Thread("qwdqwd-$i"))
        }
        val t = System.currentTimeMillis() + 2000L

        val s1 = thread(start = true, isDaemon = true) {
            println("Start - 1")
            while (t>System.currentTimeMillis()) {
                map.put("OOO", Thread("dq3132"))
            }

        }

        val s2 = thread(start = true, isDaemon = true) {
            println("Start - 2")
            while (t>System.currentTimeMillis()) {
                val ddd = map.filter { it.value.isAlive == false }.count()
                println(ddd)
            }
        }

        while (s1.isAlive || s2.isAlive) {

        }
    }
}