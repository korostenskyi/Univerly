package com.korostenskyi.app.core.command.handler;

import com.korostenskyi.app.core.command.executor.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommandHandlerImpl implements CommandHandler {

    @Autowired
    @Qualifier(value = "CommandExecutor")
    private CommandExecutor commandExecutor;

    @Override
    public String handleCommand(String command) {

        String[] splitedCommand = command.split(" ");
        String commandName = splitedCommand[0];

        switch (commandName) {

            case "help":
                return "Available commands:\n" +
                        "\thelp -> show the list of available commands\n" +
                        "\tWho is the head of department {department name} -> show the name of the head of given department\n" +
                        "\tShow {department name} statistic -> show the statistic for given department\n" +
                        "\tShow the average salary for department {department name} -> show the average salary in given department\n" +
                        "\tShow count of employee for {department name} -> show the amount of employees in given department\n" +
                        "\tGlobal search by {template} -> find the lectors by given string template\n" +
                        "\texit -> close the program";

            case "Global": {
                if (splitedCommand.length > 1) {

                    String output = commandExecutor.executeGlobalCommand(command, splitedCommand);

                    if (output == null) {
                        break;
                    }

                    return output;
                } else {
                    break;
                }
            }

            case "Show": {
                if (splitedCommand.length > 1) {

                    String output = commandExecutor.executeShowCommand(command, splitedCommand);

                    if (output == null) {
                        break;
                    }

                    return output;
                } else {
                    break;
                }
            }

            case "Who": {
                if (splitedCommand.length > 1) {

                    String output = commandExecutor.executeWhoCommand(command);

                    if (output == null) {
                        break;
                    }

                    return output;
                } else {
                    break;
                }
            }

            default:
                break;
        }

        return "Unknown command!, please type 'help' for extra help...";
    }
}
