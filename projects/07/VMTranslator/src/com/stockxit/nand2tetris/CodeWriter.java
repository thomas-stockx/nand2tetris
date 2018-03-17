package com.stockxit.nand2tetris;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CodeWriter {
    private PrintWriter mPrintWriter;

    private int labelCount = 0;

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

        // do actual operation
        switch (command) {
            case "add":
                popStackToD();
                decrementStackPointer();
                loadStackPointerToA();
                mPrintWriter.println("M=D+M");
                incrementStackPointer();
                break;
            case "sub":
                popStackToD();
                decrementStackPointer();
                loadStackPointerToA();
                mPrintWriter.println("M=M-D");
                incrementStackPointer();
                break;
            case "neg":
                decrementStackPointer();
                loadStackPointerToA();
                mPrintWriter.println("M=-M");
                incrementStackPointer();
                break;
            case "eq":
                writeCompareLogic("JEQ");
                break;
            case "gt":
                writeCompareLogic("JGT");
                break;
            case "lt":
                writeCompareLogic("JLT");
                break;
            case "and":
                popStackToD();
                decrementStackPointer();
                loadStackPointerToA();
                mPrintWriter.println("M=D&M");
                incrementStackPointer();
                break;
            case "or":
                popStackToD();
                decrementStackPointer();
                loadStackPointerToA();
                mPrintWriter.println("M=D|M");
                incrementStackPointer();
                break;
            case "not":
                decrementStackPointer();
                loadStackPointerToA();
                mPrintWriter.println("M=!M");
                incrementStackPointer();
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
                        pushDToStack();
                        break;
                }
                break;
            case C_POP:
                switch (segment) {
                    case "constant":
                        mPrintWriter.println("@"+index);
                        mPrintWriter.println("D=A");
                        mPrintWriter.println("@R13");
                        mPrintWriter.println("M=D");
                        popStackToD();
                        mPrintWriter.println("@R13");
                        mPrintWriter.println("A=M");
                        mPrintWriter.println("M=D");
                }

                break;
        }
    }

    public void close() {
        mPrintWriter.close();
    }


    private void incrementStackPointer() {
        mPrintWriter.println("@SP");
        mPrintWriter.println("M=M+1");
    }

    private void decrementStackPointer() {
        mPrintWriter.println("@SP");
        mPrintWriter.println("M=M-1");
    }

    private void popStackToD() {
        decrementStackPointer();
        mPrintWriter.println("A=M");
        mPrintWriter.println("D=M");
    }

    private void pushDToStack() {
        loadStackPointerToA();
        mPrintWriter.println("M=D");
        incrementStackPointer();
    }

    private void loadStackPointerToA() {
        mPrintWriter.println("@SP");
        mPrintWriter.println("A=M");
    }

    private void writeCompareLogic(String jumpCommand) {
        popStackToD();
        decrementStackPointer();
        loadStackPointerToA();
        mPrintWriter.println("D=M-D");
        mPrintWriter.println("@LABEL" + labelCount);
        mPrintWriter.println("D;"+jumpCommand);
        loadStackPointerToA();
        mPrintWriter.println("M=0");
        mPrintWriter.println("@ENDLABEL" + labelCount);
        mPrintWriter.println("0;JMP");
        mPrintWriter.println("(LABEL" + labelCount + ")");
        loadStackPointerToA();
        mPrintWriter.println("M=-1");
        mPrintWriter.println("(ENDLABEL" + labelCount + ")");
        incrementStackPointer();
        labelCount++;
    }

}
