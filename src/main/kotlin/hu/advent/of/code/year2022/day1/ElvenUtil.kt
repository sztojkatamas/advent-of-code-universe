package hu.advent.of.code.year2022.day1

object ElvenUtil {
    fun countElvenCalories(data: MutableList<String>): MutableList<Elf> {
        val elvzz = mutableListOf<Elf>()
        var elf = Elf()
        data.forEachIndexed { _, s ->
            if(s.isEmpty()) {
                elvzz.add(elf)
                elf = Elf()
            } else {
                elf.cucc.add(s.toInt())
            }
        }
        elvzz.add(elf)
        return elvzz
    }

}