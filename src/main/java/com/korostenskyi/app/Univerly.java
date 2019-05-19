package com.korostenskyi.app;

import com.korostenskyi.app.command.CommandHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Univerly {

    private Univerly() {
    }

    public static void launch(AnnotationConfigApplicationContext applicationContext) {

        CommandHandler commandHandler = applicationContext.getBean(CommandHandler.class);

        System.out.println("Welcome to Univerly!\nType help to get list of available commands.");

        System.out.println(commandHandler.handleCommand("Hello dfghjkl dfghjkl dfghjkl"));

    }
}
