package hu.advent.of.code.year2015.day2

class PresentBox(boxstring: String) {
    private var length: Int
    private var width: Int
    private var height: Int

    init {
        val splittedString = boxstring.split("x")
        length = splittedString[0].toInt()
        width = splittedString[1].toInt()
        height = splittedString[2].toInt()
    }

    fun wrap(): Int {
        return 2 * (length * width + width * height + length * height) + getSmallestSide()
    }

    private fun getSmallestSide(): Int {
        val sides:MutableList<Int> = mutableListOf()

        sides.add(length * width)
        sides.add(length * height)
        sides.add(height * width)

        return sides.minOrNull()!!
    }

    fun ribbon(): Int {
        val edges = mutableListOf<Int>(length, width, height)
        return (((length + width + height) - edges.maxOrNull()!!) * 2) + (length * width * height)
    }
}