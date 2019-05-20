package com.korostenskyi.app.core;

import com.korostenskyi.app.core.command.CommandHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public final class Univerly {

    private static Scanner scanner;
    private static String command;
    private static CommandHandler commandHandler;

    private Univerly() {
    }

    public static void launch(AnnotationConfigApplicationContext applicationContext) {

        commandHandler = (CommandHandler) applicationContext.getBean("CommandHandler");

        System.out.println("Welcome to Univerly!");
        System.out.println("Type help to get list of available commands.");
        System.out.print("> ");

        scanner = new Scanner(System.in);
        command = scanner.nextLine();

        while (!command.equals("exit")) {
            System.out.println(commandHandler.handleCommand(command));
            System.out.print("> ");
            command = scanner.nextLine();
        }

        System.out.println("Goodbye ^_^");
    }
}
