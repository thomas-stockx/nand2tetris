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

    while(parser.hasMoreCommands()) {
        parser.advance()

        if (parser.commandType() == CommandType.A_COMMAND) {
            // write empty line for now
            outputFile.appendText("0" + parser.symbol() + "\n")
        }

        if (parser.commandType() == CommandType.C_COMMAND) {
            outputFile.appendText("111" + code.comp(parser.comp()) + code.dest(parser.dest()) + code.jump(parser.jump()) + "\n")
        }
    }

}