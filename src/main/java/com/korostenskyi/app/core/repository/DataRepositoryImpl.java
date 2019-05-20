package com.korostenskyi.app.core.repository;

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

@Service
public class DataRepositoryImpl implements DataRepository {

    private DepartmentDao departmentDao;
    private LectorDao lectorDao;
    private ContractDao contractDao;

    public DataRepositoryImpl() {

        departmentDao = new DepartmentDao();
        lectorDao = new LectorDao();
        contractDao = new ContractDao();
    }

    /**
     * Returns the name of the head of given department.
     *
     * @param departmentName The name of the department
     * @return The name of the head of given department
     */
    @Override
    public String getHeadOfDepartmentByDepartmentName(String departmentName) {
        return departmentDao.getDepartmentByName(departmentName).getHead();
    }

    /**
     * Returns the list with the amount of professors, assosiate professors, assistants by given departmentName.
     *
     * @param departmentName The name of the department
     * @return List of Integers where first element is amount of professors, second - assosiate professors, third - assistants
     */
    @Override
    public List<Integer> getDepartmentStatsByName(String departmentName) {

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
    @Override
    public int getEmployeeCountByDepartmentName(String departmentName) {

        Department department = departmentDao.getDepartmentByName(departmentName);

        if (department == null) {
            return -1;
        }

        long departmentId = department.getId();
        List<Contract> contracts = contractDao.getContractsByDepartmentId(departmentId);

        if (contracts.size() == 0) {
            return 0;
        }

        return contracts.size();
    }

    /**
     * Returns the average salary of employees in given department.
     *
     * @param departmentName The name of the department
     * @return Average salary of employees
     */
    @Override
    public double getAverageSalaryForDepartmentByName(String departmentName) {

        long departmentId = departmentDao.getDepartmentByName(departmentName).getId();
        List<Contract> contracts = contractDao.getContractsByDepartmentId(departmentId);

        if (contracts.size() == 0) {
            return 0;
        }

        int totalSalary = contracts.stream().mapToInt(Contract::getSalary).sum();

        return totalSalary / contracts.size();
    }

    /**
     * Returns the list of names that contain the given string-part
     *
     * @param template The part of name
     * @return List of names
     */
    @Override
    public List<String> getLectorsByNameTemplate(String template) {

        List<String> names = new ArrayList<>();

        lectorDao.getLectorsByNameTemplate(template).forEach(lector -> names.add(lector.getName()));

        return names;
    }
}
