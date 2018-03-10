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
            //mPrintWriter.close();
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
        mPrintWriter.printf("// %s\n", command);
        switch (command) {
            case "add":
                // get value at SP--
                mPrintWriter.println("@SP");
                mPrintWriter.println("AM=M-1");
                mPrintWriter.println("D=M");
                // get value at SP-2
                mPrintWriter.println("@SP");
                mPrintWriter.println("AM=M-1");
                // add values and store in SP
                mPrintWriter.println("M=D+M");
                // increment SP;
                mPrintWriter.println("@SP");
                mPrintWriter.println("M=M+1");
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
                mPrintWriter.printf("// push %s %d\n", segment, index);
                switch (segment) {
                    case "constant":
                        // store value in D
                        mPrintWriter.println("@"+index);
                        mPrintWriter.println("D=A");
                        // use value of SP for address
                        mPrintWriter.println("@SP");
                        mPrintWriter.println("A=M");
                        // store constant in at SP
                        mPrintWriter.println("M=D");
                        // increment SP
                        mPrintWriter.println("@SP");
                        mPrintWriter.println("M=M+1");
                        break;
                }
                break;
            case C_POP:
                break;
        }
    }

    public void close() {
        mPrintWriter.close();
    }
}
