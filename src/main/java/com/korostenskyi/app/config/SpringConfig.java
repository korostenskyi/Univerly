package com.korostenskyi.app.config;

import com.korostenskyi.app.command.CommandHandler;
import com.korostenskyi.app.command.CommandHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.korostenskyi.app")
public class SpringConfig {

    @Bean
    public CommandHandler commandHandler() {
        return new CommandHandlerImpl();
    }
}
