package com.stockxit.nand2tetris;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // TODO support folders (multiple input files)
        File inputFile = new File(args[0]);

        // TODO support multiple output files
        File outputFile = new File(args[0].split(".vm")[0] + ".asm");



    }
}
