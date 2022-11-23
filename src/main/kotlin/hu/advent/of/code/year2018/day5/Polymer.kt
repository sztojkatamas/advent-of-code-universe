package hu.advent.of.code.year2018.day5

object Polymer {

    fun reduce(rawPolymer: String): String {
        var polymer = rawPolymer
        rawPolymer.forEach {
            val rpc = it.toString().lowercase() + it.toString().uppercase()
            polymer = polymer.replace(rpc, "").replace(rpc.reversed(),"")
        }
        return polymer
    }

    fun strip(badUnit: String, polymer: String): String {
        return polymer.replace(badUnit.lowercase(),"").replace(badUnit.uppercase(),"")
    }

}