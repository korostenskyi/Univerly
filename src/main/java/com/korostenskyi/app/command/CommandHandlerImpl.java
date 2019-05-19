package com.korostenskyi.app.command;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandHandlerImpl implements CommandHandler {

    private String command;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String handleCommand(String command) {

        List<String> wordList = Arrays.asList(command.split(" "));

        return command;
    }
}
