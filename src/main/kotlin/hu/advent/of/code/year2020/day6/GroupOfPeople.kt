package hu.advent.of.code.year2020.day6

class GroupOfPeople {
    private var answers = mutableMapOf<Char, Int>()
    private var numberOfPeople = 0

    fun getAnswers() : Int {
        return answers.size
    }

    fun getAllYesAnswers() : Int {
        var allyes = 0
        for (i in answers) {
            if (i.value == numberOfPeople) {
                allyes++
            }
        }
        return allyes
    }

    fun processLine(line :String) : Boolean {

        if (line.trim().isEmpty()) {
            return false
        }

        for (i in line.trim()) {
            if (answers.containsKey(i)) {
                answers[i]?.let { answers.put(i, it+1) }
            } else {
                answers[i] = 1
            }
        }
        numberOfPeople++

        return true
    }
}