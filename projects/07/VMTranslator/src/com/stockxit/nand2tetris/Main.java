package com.stockxit.nand2tetris;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO support folders (multiple input files)
        File inputFile = new File(args[0]);
        // TODO support multiple output files
        File outputFile = new File(args[0].split(".vm")[0] + ".asm");


        Scanner inputScanner = null;
        try {
            inputScanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Parser parser = new Parser(inputScanner);
        CodeWriter codeWriter = new CodeWriter(outputFile);

        while (parser.hasMoreCommands()) {
            parser.advance();
            switch (parser.commandType()) {
                case C_PUSH:
                case C_POP:
                    codeWriter.writePushPop(parser.commandType(), parser.arg1(), parser.arg2());
                    break;
                case C_ARITHMETIC:
                    codeWriter.writeArithmetic(parser.arg1());
                    break;
            }
        }
        codeWriter.close();

    }
}
