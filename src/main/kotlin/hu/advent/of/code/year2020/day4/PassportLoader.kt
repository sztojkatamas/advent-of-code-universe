package hu.advent.of.code.year2020.day4

object PassportLoader {

    fun createPassportsFromRawData(data : List<String>) : MutableList<Passport>{
        val listOfPassports = mutableListOf<Passport>()
        var passport = Passport()
        listOfPassports.add(passport)

        for (line in data) {
            if (!passport.process(line)) {
                passport = Passport()
                listOfPassports.add(passport)
            }
        }
        return listOfPassports
    }

}