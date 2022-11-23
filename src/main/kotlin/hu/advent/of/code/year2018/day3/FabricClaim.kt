package hu.advent.of.code.year2018.day3

data class FabricClaim(var id: String, var x: Int, var y: Int, var width: Int, var height: Int) {

    constructor(strings: List<String>) : this(
        strings[0].trim(),
        strings[1].trim().toInt(),
        strings[2].trim().toInt(),
        strings[3].trim().toInt(),
        strings[4].trim().toInt(),
    )
}