package hu.advent.of.code.year2020.day7

@Suppress("kotlin:S100")
class Bag(val name :String) {
    private var parent: Bag = this
    private var root = true
    private val contents = mutableMapOf<Bag, Int>()

    fun getBag(bagName: String) : Bag {
        return contents.keys.first { it.name == bagName }
    }
    fun hasBag(bagName: String): Boolean {
        return contents.keys.filter { it.name == bagName}.count() > 0
    }

    fun hasThatManyBags(bagName :String) : Int {
        `fathers' fathers' fathers' fathers`()
        return contents[getBag(bagName)]!!
    }

    fun setParent(bigbag: Bag) {
        parent = bigbag
        root = false
    }

    fun addBag(bag: Bag, quantity: Int) {
        contents.put(bag, quantity)
    }






    fun `fathers' fathers' fathers' fathers`(): Bag {
        if (root) {
            return this
        } else {
            return parent.`fathers' fathers' fathers' fathers`()
        }
    }



    fun getBags() : List<Bag> {
        var ret = mutableListOf<Bag>()
        contents.forEach {
            ret.add(it.key) }
        return ret
    }

    override fun toString() :String {
        return "|$name| [$contents]\n"
    }
}