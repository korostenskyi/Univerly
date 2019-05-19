package com.korostenskyi.app;

import com.korostenskyi.app.command.CommandHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class Univerly {

    private Univerly() {
    }

    public static void launch(AnnotationConfigApplicationContext applicationContext) {

        CommandHandler commandHandler = (CommandHandler) applicationContext.getBean("CommandHandler");

        System.out.println("Welcome to Univerly!\nType help to get list of available commands.");

        System.out.println(commandHandler.handleCommand("Hello"));

    }
}
