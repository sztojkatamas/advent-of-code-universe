package hu.advent.of.code.year2019.day2

object IntCodeProgramRunner {

    fun processCode(orig: IntArray): IntArray {
        val code = orig.copyOf()
        var operationPointer = 0
        while (code[operationPointer] != 99) {
            val operand1 = code[code[operationPointer+1]]
            val operand2 = code[code[operationPointer+2]]

            if (code[operationPointer] == 1) {
                code[code[operationPointer+3]] = operand1 + operand2
            } else if (code[operationPointer] == 2) {
                code[code[operationPointer+3]] = operand1 * operand2
            }
            operationPointer += 4
        }
        return code
    }

}