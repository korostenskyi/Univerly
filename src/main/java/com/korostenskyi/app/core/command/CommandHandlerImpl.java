package com.korostenskyi.app.core.command;

import com.korostenskyi.app.core.data.dao.ContractDao;
import com.korostenskyi.app.core.data.dao.DepartmentDao;
import com.korostenskyi.app.core.data.dao.LectorDao;
import com.korostenskyi.app.core.data.entity.Contract;
import com.korostenskyi.app.core.data.entity.Degree;
import com.korostenskyi.app.core.data.entity.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandHandlerImpl implements CommandHandler {

    private ContractDao contractDao;
    private DepartmentDao departmentDao;
    private LectorDao lectorDao;

    public CommandHandlerImpl() {

        contractDao = new ContractDao();
        departmentDao = new DepartmentDao();
        lectorDao = new LectorDao();
    }

    @Override
    public String handleCommand(String command) {

        String[] splitedCommand = command.split(" ");
        String commandName = splitedCommand[0];

        switch (commandName) {

            case "help":
                // TODO: Complete the 'help' command description
                return "Read the docs!";

            case "Global": {
                if (splitedCommand.length > 1) {
                    if (splitedCommand[1].equals("search") && splitedCommand[2].equals("by")) {
                        return "[" + getLectorsByNameTemplate(splitedCommand[3]).stream().map(Object::toString)
                                .collect(Collectors.joining(", ")) + "]";
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            case "Show": {
                if (splitedCommand.length > 1) {
                    return handleShowCommand(splitedCommand);
                } else {
                    break;
                }
            }

            default:
                break;
        }

        return "Unknown command!, please type 'help' for extra help...";
    }

    private String handleShowCommand(String[] args) {

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

            List<Integer> answer = getDepartmentStatsByName(name);

            return "Assistants: " + answer.get(2) +
                    " , assosiated professors: " + answer.get(1) +
                    ", professors: " + answer.get(0);
        } else {
            return "";
        }
    }

    /**
     * Returns the name of the head of given department.
     *
     * @param departmentName The name of the department
     * @return The name of the head of given department
     */
    private String getHeadOfDepartmentByDepartmentName(String departmentName) {
        return departmentDao.getDepartmentByName(departmentName).getHead();
    }

    /**
     * Returns the list with the amount of professors, assosiate professors, assistants by given departmentName.
     *
     * @param departmentName The name of the department
     * @return List of Integers where first element is amount of professors, second - assosiate professors, third - assistants
     */
    private List<Integer> getDepartmentStatsByName(String departmentName) {

        int professorCount = 0;
        int assosiateProfessorCount = 0;
        int assistantCount = 0;

        Department department = departmentDao.getDepartmentByName(departmentName);
        long departmentId;

        if (department != null) {
            departmentId = department.getId();
        } else {
            return Arrays.asList(-1, -1, -1);
        }

        List<Contract> contracts = contractDao.getContractsByDepartmentId(departmentId);

        for (Contract element : contracts) {

            long lectorId = element.getLectorId();

            Degree degree = lectorDao.getLectorById(lectorId).getDegree();

            switch (degree) {
                case PROFESSOR:
                    professorCount++;
                    break;
                case ASSOSIATE_PROFESSOR:
                    assosiateProfessorCount++;
                    break;
                case ASSISTANT:
                    assistantCount++;
                    break;
            }
        }

        return Arrays.asList(professorCount, assosiateProfessorCount, assistantCount);
    }

    /**
     * Returns the amount of employees in given department.
     *
     * @param departmentName The name of the department
     * @return Amount of employees
     */
    private int getEmployeeCountByDepartmentName(String departmentName) {

        long departmentId = departmentDao.getDepartmentByName(departmentName).getId();
        List<Contract> contracts = contractDao.getContractsByDepartmentId(departmentId);

        return contracts.size();
    }

    /**
     * Returns the average salary of employees in given department.
     *
     * @param departmentName The name of the department
     * @return Average salary of employees
     */
    private double getAverageSalaryForDepartmentByName(String departmentName) {

        long departmentId = departmentDao.getDepartmentByName(departmentName).getId();
        List<Contract> contracts = contractDao.getContractsByDepartmentId(departmentId);

        int totalSalary = contracts.stream().mapToInt(Contract::getSalary).sum();

        return totalSalary / contracts.size();
    }

    /**
     * Returns the list of names that contain the given string-part
     *
     * @param template The part of name
     * @return List of names
     */
    private List<String> getLectorsByNameTemplate(String template) {

        List<String> names = new ArrayList<>();

        lectorDao.getLectorsByNameTemplate(template).forEach(lector -> names.add(lector.getName()));

        return names;
    }
}
