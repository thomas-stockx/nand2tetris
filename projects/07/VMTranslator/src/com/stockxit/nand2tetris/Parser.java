package com.stockxit.nand2tetris;

import java.util.Scanner;

public class Parser {
    private Scanner mScanner;
    private String mCurrentCommand;

    public Parser(Scanner scanner) {
        this.mScanner = scanner;
    }

    public boolean hasMoreCommands() {
        return mScanner.hasNextLine();
    }

    public void advance() {
        if (hasMoreCommands()) {
            mCurrentCommand = mScanner.nextLine();

            // strip out comment
            int commentIndex = mCurrentCommand.indexOf("/");
            if (commentIndex >= 0) {
                mCurrentCommand = mCurrentCommand.substring(0, commentIndex);
            }

            // trim just to be sure
            mCurrentCommand = mCurrentCommand.trim();

            if (mCurrentCommand.isEmpty()) {
                advance();
            }
        }
    }

    public CommandType commandType() {
        String command = mCurrentCommand.split(" ")[0];
        switch (command) {
            case "push":
                return CommandType.C_PUSH;
            case "pop":
                return CommandType.C_POP;
            default:
                return CommandType.C_ARITHMETIC;
        }
    }

    public String arg1() {
        if (commandType() == CommandType.C_RETURN) {
            return null;
        }

        if (commandType() == CommandType.C_ARITHMETIC) {
            return mCurrentCommand;
        }

        return mCurrentCommand.split(" ")[1];
    }

    public int arg2() {
        if (commandType() == CommandType.C_PUSH
                || commandType() == CommandType.C_POP
                || commandType() == CommandType.C_FUNCTION
                || commandType() == CommandType.C_CALL) {
            return Integer.valueOf(mCurrentCommand.split(" ")[2]);
        }

        return 0;
    }
}
