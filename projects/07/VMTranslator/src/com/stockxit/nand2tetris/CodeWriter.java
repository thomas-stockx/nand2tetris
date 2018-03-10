package com.stockxit.nand2tetris;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CodeWriter {
    private PrintWriter mPrintWriter;

    public CodeWriter(File file) {
        mPrintWriter = null;
        try {
            mPrintWriter = new PrintWriter(new FileWriter(file));
            mPrintWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFileName(String fileName) {
        try {
            mPrintWriter = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeArithmetic(String command) {
        // TODO
        switch (command) {
            case "add":
                break;
            case "sub":
                break;
            case "neg":
                break;
            case "eq":
                break;
            case "gt":
                break;
            case "lt":
                break;
            case "and":
                break;
            case "or":
                break;
            case "not":
                break;
        }
    }

    public void writePushPop(CommandType commandType, String segment, int index) {
        // TODO
        switch (commandType) {
            case C_PUSH:
                break;
            case C_POP:
                break;
        }
    }

    public void close() {
        mPrintWriter.close();
    }
}
