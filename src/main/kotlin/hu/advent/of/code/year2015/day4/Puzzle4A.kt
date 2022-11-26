package hu.advent.of.code.year2015.day4

import hu.advent.of.code.AdventOfCodePuzzle
import hu.advent.of.code.BaseChallenge
import java.security.MessageDigest

@AdventOfCodePuzzle
class Puzzle4A:BaseChallenge(2015) {
    override fun run() {
        printPuzzleName()
        val mySecret = "bgvyzdsv"
        var salt = 250000L // Speedup :)

        while (!goodMD5(mySecret, salt)) {
            salt++
        }
        println(salt)
    }

    fun goodMD5(secret:String, sequence:Long):Boolean {
        val s =secret.plus(sequence.toString()).md5()
        if(s.startsWith("00000")) {
            println(s)
            return true
        }
        return false
    }

    private
    fun String.md5(): String {
        return MessageDigest.getInstance("MD5").digest(this.toByteArray()).toHex()
    }

    fun ByteArray.toHex(): String {
        return joinToString("") { "%02x".format(it) }
    }
}
