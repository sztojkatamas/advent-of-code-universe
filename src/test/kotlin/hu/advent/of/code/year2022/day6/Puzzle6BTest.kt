package hu.advent.of.code.year2022.day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Puzzle6BTest {

    @Test
    fun `test data streams for message markers`() {
        assertEquals(19, "mjqjpqmgbljsphdztnvjfqwrcgsmlb".findMarker(14))
        assertEquals(23, "bvwbjplbgvbhsrlpgdmjqwftvncz".findMarker(14))
        assertEquals(23, "nppdvjthqldpwncqszvftbrmjlhg".findMarker(14))
        assertEquals(29, "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg".findMarker(14))
        assertEquals(26, "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw".findMarker(14))
    }
}