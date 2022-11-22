package hu.advent.of.code.year2015.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ItineraryTest {

    @Test
    fun testGetNumberOfVisitedHouses() {
        assertEquals(Itinerary(">").walk().getNumberOfVisitedHouses(), 2)
        assertEquals(Itinerary("^>v<").walk().getNumberOfVisitedHouses(), 4)
        assertEquals(Itinerary("^v^v^v^v^v").walk().getNumberOfVisitedHouses(), 2)
    }


    @Test
    fun testItinerarySplit() {
        assertEquals(Itinerary("^v").getPath(Itinerary.SANTA), "^")
        assertEquals(Itinerary("^v").getPath(Itinerary.ROBOT), "v")
        assertEquals(Itinerary("^>v<").getPath(Itinerary.SANTA), "^v")
        assertEquals(Itinerary("^>v<").getPath(Itinerary.ROBOT), "><")
        assertEquals(Itinerary("^v^v^v^v^v").getPath(Itinerary.SANTA), "^^^^^")
        assertEquals(Itinerary("^v^v^v^v^v").getPath(Itinerary.ROBOT), "vvvvv")
    }

    @Test
    fun testSantaAndRobot() {
        assertEquals(
        (Itinerary(Itinerary("^v^v^v^v^v").getPath(Itinerary.SANTA)).walk().map +
        Itinerary(Itinerary("^v^v^v^v^v").getPath(Itinerary.ROBOT)).walk().map).filter { it.value >= 1 }.count()
        ,11)

    }
}