package hu.advent.of.code.year2022.day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle6ATest {

    @Test
    fun `test data streams for packet markers`() {
        assertEquals(5, "bvwbjplbgvbhsrlpgdmjqwftvncz".findMarker(4))
        assertEquals(6, "nppdvjthqldpwncqszvftbrmjlhg".findMarker(4))
        assertEquals(10, "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".findMarker(4))
        assertEquals(11, "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".findMarker(4))
    }
}