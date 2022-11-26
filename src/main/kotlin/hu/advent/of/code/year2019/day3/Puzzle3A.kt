package hu.advent.of.code.year2019.day3

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import kotlin.math.abs

@AdventOfCodePuzzle
class Puzzle3A: BaseChallenge(2019) {

    override fun run() {
        printPuzzleName()
        loadDataFromFile("data3.txt")
        println("Minimum Manhattan distance is: ${getMinimalManhattanDistance(data[0], data[1])}")
    }

    fun makeVectorList(input:String): MutableCollection<Vector2D> {
        var lastPoint = Point(0,0)
        val list = mutableListOf<Vector2D>()
        val split = input.split(",")
        for (i in split.indices) {
            val nextPoint = lastPoint.copy()
            when (split[i].first()) {
                'U' -> nextPoint.y += split[i].substring(1).toInt()
                'D' -> nextPoint.y -= split[i].substring(1).toInt()
                'R' -> nextPoint.x += split[i].substring(1).toInt()
                'L' -> nextPoint.x -= split[i].substring(1).toInt()
            }
            list.add(Vector2D(lastPoint, nextPoint))
            lastPoint = nextPoint.copy()
        }
        return list
    }

    fun intersectCheck(op1: Vector2D, op2: Vector2D): Boolean {
        return doIntersect(op1.from, op1.to, op2.from, op2.to)
    }

    fun doIntersect(p1: Point, q1: Point, p2: Point, q2: Point): Boolean {
        val o1: Int = orientation(p1, q1, p2)
        val o2: Int = orientation(p1, q1, q2)
        val o3: Int = orientation(p2, q2, p1)
        val o4: Int = orientation(p2, q2, q1)

        if (o1 != o2 && o3 != o4) return true
        if (o1 == 0 && onSegment(p1, p2, q1)) return true
        if (o2 == 0 && onSegment(p1, q2, q1)) return true
        if (o3 == 0 && onSegment(p2, p1, q2)) return true
        return (o4 == 0 && onSegment(p2, q1, q2))
    }

    fun orientation(p: Point, q: Point, r: Point): Int {
        val orientation = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y)
        if (orientation == 0) return 0
        return if (orientation > 0) 1 else 2
    }

    fun onSegment(p: Point, q: Point, r: Point): Boolean {
        return (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
    }

    fun getIntersectionPoint(v1: Vector2D, v2: Vector2D): Point {
        return v1.getPointOnSegment() + v2.getPointOnSegment()
    }

    fun getMinimalManhattanDistance(s1: String, s2: String): Manhattan {
        var minDistance = Int.MAX_VALUE
        var minWireLength = Int.MAX_VALUE
        val v1List = makeVectorList(s1)
        val v2List = makeVectorList(s2)
        for (i in v1List) {
            for (j in v2List) {
                if(intersectCheck(i, j)) {
                    val p = getIntersectionPoint(i, j)
                    val localMin = abs(p.x) + abs(p.y)
                    if (localMin in 1 until minDistance) {
                        minDistance = localMin
                    }
                    val wireOneLength = getWireLength(v1List, i.from)
                    val wireTwoLength = getWireLength(v2List, j.from)
                    val total = wireOneLength + wireTwoLength + Vector2D(i.from, p).length + Vector2D(j.from, p).length
                    if (total in 1 until minWireLength) {
                        minWireLength = total
                    }
                }
            }
        }
        return Manhattan(minDistance, minWireLength)
    }

    fun getWireLength(vectorList: MutableCollection<Vector2D>, point: Point): Int {
        var wireLength = 0
        for (i in vectorList) {
            wireLength += i.length
            if (i.to == point) {
                return  wireLength
            }
        }
        return 0
    }

}

data class Manhattan(val minDistance:Int, val minWireLength:Int)

data class Point(var x:Int, var y:Int) {

    operator fun plus(p2: Point): Point {
        this.x += p2.x
        this.y += p2.y
        return this
    }
}

data class Vector2D(val from: Point, val to: Point) {
    val length = abs(from.x - to.x) + abs(from.y - to.y)

    fun getPointOnSegment(): Point {
        return when (from.x == to.x) {
            true -> Point(from.x, 0)
            else -> Point(0, from.y)
        }
    }
}