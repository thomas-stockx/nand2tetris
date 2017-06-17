import java.io.File
import java.util.*

/**
 * Created by thomasstockx on 10/06/2017.
 */
fun main(args: Array<String>) {
    val file = File(args[0])
    val scanner = Scanner(file)

    val parser = Parser(scanner)
    val code = Code()

    val outputFile = File(args[0].split(".asm")[0] + ".hack")

    // clean the output file
    outputFile.writeText("")

    // First Pass: fill Symbol Table with labels
    var symbolTable = SymbolTable()
    var address = 0
    while(parser.hasMoreCommands()) {
        parser.advance()

        if (parser.commandType() == CommandType.L_COMMAND) {
            symbolTable.addEntry(parser.symbol(), address)
        } else {
            address++
        }
    }

    // Second Pass
    val scanner2 = Scanner(file)
    val parser2 = Parser(scanner2)
    address = 16
    while(parser2.hasMoreCommands()) {
        parser2.advance()

        if (parser2.commandType() == CommandType.A_COMMAND) {
            // write empty line for now
            // check for Label of number
            try {
                parser2.symbol().toDouble()
                outputFile.appendText("0" + parser2.integerToBinary(parser2.symbol()) + "\n")
            } catch(e: NumberFormatException) {
                if (!symbolTable.contains(parser2.symbol())) {
                    symbolTable.addEntry(parser2.symbol(), address)
                    address++
                }

                outputFile.appendText("0" + parser2.integerToBinary("" + symbolTable.getAddress(parser2.symbol())) + "\n")
            }

        }

        if (parser2.commandType() == CommandType.C_COMMAND) {
            outputFile.appendText("111" + code.comp(parser2.comp()) + code.dest(parser2.dest()) + code.jump(parser2.jump()) + "\n")
        }
    }

}