package com.korostenskyi.app.core.command.executor;

import com.korostenskyi.app.core.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandExecutorImpl implements CommandExecutor {

    @Autowired
    @Qualifier(value = "DataRepository")
    private DataRepository dataRepository;

    @Override
    public String executeWhoCommand(String command) {

        if (command.contains("is head of department")) {

            String departmentName = command.substring(26);

            return "Head of " + departmentName + " department is " + dataRepository.getHeadOfDepartmentByDepartmentName(departmentName);
        } else {
            return null;
        }
    }

    @Override
    public String executeShowCommand(String command, String[] args) {

        if (args[args.length - 1].equals("statistic")) {

            String name = "";

            if (args.length > 3) {
                for (int i = 1; i < args.length - 1; i++) {
                    name += (args[i] + " ");
                }

                name = name.substring(0, name.length() - 1);
            } else {
                name = args[1];
            }

            List<Integer> answer = dataRepository.getDepartmentStatsByName(name);

            return "Assistants: " + answer.get(2) +
                    ", assosiated professors: " + answer.get(1) +
                    ", professors: " + answer.get(0);
        } else {

            String departmentName = command.substring(27);

            if (command.contains("count of employee for")) {
                return "" + dataRepository.getEmployeeCountByDepartmentName(departmentName);
            } if (command.contains("the average salary for department")) {
                return "The average salary of " + departmentName + " is " + dataRepository.getAverageSalaryForDepartmentByName(departmentName);
            } else {
                return null;
            }
        }
    }

    @Override
    public String executeGlobalCommand(String command, String[] args) {
        if (args[1].equals("search") && args[2].equals("by")) {
            return "[" + dataRepository.getLectorsByNameTemplate(args[3]).stream().map(Object::toString)
                    .collect(Collectors.joining(", ")) + "]";
        } else {
            return null;
        }
    }
}
