package com.korostenskyi.app.core.command.executor;

public interface CommandExecutor {

    String executeWhoCommand(String command);
    String executeShowCommand(String command, String[] args);
    String executeGlobalCommand(String command, String[] args);
}
