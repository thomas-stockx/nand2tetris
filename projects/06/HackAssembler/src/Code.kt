/**
 * Created by thomasstockx on 11/06/2017.
 */

class Code {
    fun dest(dest: String): String {
        when (dest) {
            "" -> return "000"
            "M" -> return "001"
            "D" -> return "010"
            "MD" -> return "011"
            "A" -> return "100"
            "AM" -> return "101"
            "AD" -> return "110"
            "AMD" -> return "111"
        }
        return ""
    }

    fun comp(comp: String): String {
        when (comp) {
            "0" -> return "0101010"
            "1" -> return "0111111"
            "-1" -> return "0111010"
            "D" -> return "0001100"
            "A" -> return "0110000"
            "!D" -> return "0001101"
            "!A" -> return "0110001"
            "-D" -> return "0001111"
            "-A" -> return "0110011"
            "D+1" -> return "0011111"
            "A+1" -> return "0110111"
            "D-1" -> return "0001110"
            "A-1" -> return "0110010"
            "D+A" -> return "0000010"
            "D-A" -> return "0010011"
            "A-D" -> return "0000111"
            "D&A" -> return "0000000"
            "D|A" -> return "0010101"
            "M" -> return "1110000"
            "!M" -> return "1110001"
            "-M" -> return "1110011"
            "M+1" -> return "1110111"
            "M-1" -> return "1110010"
            "D+M" -> return "1000010"
            "D-M" -> return "1010011"
            "M-D" -> return "1000111"
            "D&M" -> return "1000000"
            "D|M" -> return "1010101"
        }
        return ""
    }

    fun jump(jump: String): String {
        when (jump) {
            "" -> return "000"
            "JGT" -> return "001"
            "JEQ" -> return "010"
            "JGE" -> return "011"
            "JLT" -> return "100"
            "JNE" -> return "101"
            "JLE" -> return "110"
            "JMP" -> return "111"
        }
        return ""
    }
}