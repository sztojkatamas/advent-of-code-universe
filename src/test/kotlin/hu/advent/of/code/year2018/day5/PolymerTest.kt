package hu.advent.of.code.year2018.day5

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class PolymerTest {

    @Test
    fun reduceTest() {
        assertEquals("dabCBAcaDA", Polymer.reduce("dabAcCaCBAcCcaDA"))
    }

    @Test
    fun stripTest() {
        assertEquals("dbcCCBcCcD", Polymer.strip("A","dabAcCaCBAcCcaDA"))
        assertEquals("daAcCaCAcCcaDA", Polymer.strip("B","dabAcCaCBAcCcaDA"))
        assertEquals("dabAaBAaDA", Polymer.strip("C","dabAcCaCBAcCcaDA"))
        assertEquals("abAcCaCBAcCcaA", Polymer.strip("D","dabAcCaCBAcCcaDA"))
    }
}