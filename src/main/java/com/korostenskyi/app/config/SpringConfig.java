package com.korostenskyi.app.config;

import com.korostenskyi.app.core.command.executor.CommandExecutor;
import com.korostenskyi.app.core.command.executor.CommandExecutorImpl;
import com.korostenskyi.app.core.command.handler.CommandHandler;
import com.korostenskyi.app.core.command.handler.CommandHandlerImpl;
import com.korostenskyi.app.core.repository.DataRepository;
import com.korostenskyi.app.core.repository.DataRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.korostenskyi.app.core")
public class SpringConfig {

    @Bean(value = "DataRepository")
    public DataRepository dataRepository() {
        return new DataRepositoryImpl();
    }

    @Bean(value = "CommandExecutor")
    public CommandExecutor commandExecutor() {
        return new CommandExecutorImpl();
    }

    @Bean(value = "CommandHandler")
    public CommandHandler commandHandler() {
        return new CommandHandlerImpl();
    }
}
