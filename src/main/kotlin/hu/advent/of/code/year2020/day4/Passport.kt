package hu.advent.of.code.year2020.day4

class Passport {

    private val properties = mutableMapOf<String, String>()

    fun process(line :String) : Boolean{
        if (line.trim().isEmpty()) {
            return false
        }

        for (i in line.trim().split(" ")) {
            val pairs = i.split(":")
            properties[pairs[0]] = pairs[1]
        }
        return true
    }

    fun isValid() : Boolean {
        if (properties.size < 7) {
            return false
        }
        if(
                properties["byr"].equals(null) ||
                properties["iyr"].equals(null) ||
                properties["eyr"].equals(null) ||
                properties["hgt"].equals(null) ||
                properties["hcl"].equals(null) ||
                properties["ecl"].equals(null) ||
                properties["pid"].equals(null)
        ) {
            return false
        }
        return true
    }

    fun isStrictValid() : Boolean {
        if (isValid()) {
            return properties["byr"]?.toInt()!!.between(1920, 2002) &&
            properties["iyr"]?.toInt()!!.between(2010, 2020) &&
            properties["eyr"]?.toInt()!!.between(2020, 2030) &&
            checkHGT() &&
            checkHCL() &&
            checkECL() &&
            checkPID()
        }
        return false
    }

    private fun checkPID(): Boolean {
        if (!properties["pid"].equals(null)) {
            return properties["pid"]!!.length.equals(9)
        }
        return false
    }

    private fun checkHGT(): Boolean {
        return when (val height = properties["hgt"]) {
            null -> { false}
            else -> {
                when (height.takeLast(2)) {
                    "cm" -> {
                        height.substring(0, (height.length) - 2).toInt().between(150, 193)
                    }
                    "in" -> {
                        height.substring(0, (height.length) - 2).toInt().between(59, 76)
                    }
                    else -> false
                }
            }
        }
    }

    private fun checkHCL(): Boolean {
        if (!properties["hcl"].equals(null)) {
            val sss = properties["hcl"]!!
            if (sss.startsWith("#") && sss.length.equals(7)) {
                for (s in sss.substring(1)) {
                    if (s in 'a'..'f' || s in '0'..'9') {
                        continue
                    } else {
                        return false
                    }
                }
                return true
            }
        }
        return false
    }

    private fun checkECL() :Boolean {
        if(!properties["ecl"].equals(null)) {
            return listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(properties["ecl"])
        }
        return false
    }

    private fun Int.between(a:Int, b:Int) : Boolean {
        return this in a..b
    }

    override fun toString(): String {
        return "byr (Birth Year): ${properties["byr"]}\n" +
        "iyr (Issue Year): ${properties["iyr"]}\n" +
        "eyr (Expiration Year): ${properties["eyr"]}\n" +
        "hgt (Height): ${properties["hgt"]}\n" +
        "hcl (Hair Color): ${properties["hcl"]}\n" +
        "ecl (Eye Color): ${properties["ecl"]}\n" +
        "pid (Passport ID): ${properties["pid"]}\n" +
        "cid (Country ID): ${properties["cid"]}\n\n"
    }
}