package hu.advent.of.code.year2019.day3

import hu.advent.of.code.year2019.day3.Manhattan
import hu.advent.of.code.year2019.day3.Point
import hu.advent.of.code.year2019.day3.Puzzle3A
import hu.advent.of.code.year2019.day3.Vector2D
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class Puzzle3ATest {
    val puzzle = Puzzle3A()

    @Test
    fun testCreateVectorList() {
        val input = "R8,U5,L5,D3"
        val list = mutableListOf<Vector2D>()
        list.add(Vector2D(Point(0,0), Point(8,0)))
        list.add(Vector2D(Point(8,0), Point(8,5)))
        list.add(Vector2D(Point(8,5), Point(3, 5)))
        list.add(Vector2D(Point(3,5), Point(3, 2)))

        assertEquals(puzzle.makeVectorList(input), list)
    }

    @Test
    fun testIntersection() {
        assertTrue(puzzle.intersectCheck(
                Vector2D(Point(0,0), Point(5,0)),
                Vector2D(Point(3,-1), Point(3,3))
        ))

        assertFalse(puzzle.intersectCheck(
                Vector2D(Point(0,0), Point(5,0)),
                Vector2D(Point(0,-1), Point(3,-1))
        ))

        assertFalse(puzzle.intersectCheck(
                Vector2D(Point(0,0), Point(10,0)),
                Vector2D(Point(5,10), Point(5,1))
        ))
    }

    @Test
    fun testIntersectionPoint() {
        assertEquals(puzzle.getIntersectionPoint(
                Vector2D(Point(0,0), Point(5,0)),
                Vector2D(Point(2,5), Point(2,-3))
        ), Point(2,0)
        )
    }

    @Test
    fun testVectorLength() {
        val vec1 = Vector2D(Point(1,1), Point(3,1))
        val vec2 = Vector2D(Point(0,1), Point(17,1))
        assertEquals(vec1.length, 2)
        assertEquals(vec2.length, 17)
    }

    @Test
    fun testWireLengthCalculator() {
        val vList = puzzle.makeVectorList("R8,U5,L5,D3")
        val p = Point(3, 5)
        assertEquals(puzzle.getWireLength(vList, p), 18)

    }

    @Test
    fun testNearestIntersection() {
        assertEquals(puzzle.getMinimalManhattanDistance(
                "R8,U5,L5,D3",
                "U7,R6,D4,L4"), Manhattan(6,30)
        )

        assertEquals(puzzle.getMinimalManhattanDistance(
                "R75,D30,R83,U83,L12,D49,R71,U7,L72",
                "U62,R66,U55,R34,D71,R55,D58,R83"), Manhattan(159,610)
        )

        assertEquals(puzzle.getMinimalManhattanDistance(
                "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
                "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"), Manhattan(135,410)
        )



    }
}