import java.util.*

/**
 * Created by thomasstockx on 10/06/2017.
 */
class Parser(var scanner: Scanner) {

    var currentCommand = ""

    var myMap = HashMap<Int,String>()

    fun hasMoreCommands(): Boolean {
        return scanner.hasNextLine()
    }

    fun reset() {
        scanner = scanner.reset()
    }

    fun advance() {
        if (hasMoreCommands()) {
            currentCommand = scanner.nextLine()

            // strip out comment
            var commentIndex = currentCommand.indexOf("/")
            if (commentIndex >= 0) {
                currentCommand = currentCommand.substring(0, commentIndex)
            }

            // strip out whitespace
            currentCommand = currentCommand.replace(" ", "")

            if (currentCommand.isBlank()) {
                advance()
            }
        }
    }

    fun commandType(): CommandType {
        if (currentCommand.startsWith("@")) {
            return CommandType.A_COMMAND
        }
        if (currentCommand.startsWith("(")) {
            return CommandType.L_COMMAND
        }
        return CommandType.C_COMMAND
    }

    fun symbol(): String {
        if(commandType() == CommandType.A_COMMAND) {
            return currentCommand.substring(1)
        }

        if(commandType() == CommandType.L_COMMAND) {
            return currentCommand.substring(1, currentCommand.length - 1)
        }

        return ""
    }

    fun dest(): String {
        if (commandType() == CommandType.C_COMMAND) {
            var temp = currentCommand.split("=")[0]
            return if (currentCommand.contains(";")) "" else temp
        }

        return ""
    }

    fun comp(): String {
        if (commandType() == CommandType.C_COMMAND) {
            var temp = if (currentCommand.contains("=")) currentCommand.split("=")[1] else currentCommand
            return temp.split(";")[0]
        }

        return ""
    }

    fun jump(): String {
        if (commandType() == CommandType.C_COMMAND && currentCommand.contains(";")) {
            return currentCommand.split(";")[1]
        }

        return ""
    }

    fun integerToBinary(integer: String): String {
        var binary = Integer.toBinaryString(Integer.parseInt(integer))
        while (binary.length < 15) {
            binary = "0" + binary
        }
        return binary
    }


}