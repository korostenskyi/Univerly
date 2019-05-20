package com.korostenskyi.app.core.repository;

import java.util.List;

public interface DataRepository {

    String getHeadOfDepartmentByDepartmentName(String departmentName);
    List<Integer> getDepartmentStatsByName(String departmentName);
    int getEmployeeCountByDepartmentName(String departmentName);
    double getAverageSalaryForDepartmentByName(String departmentName);
    List<String> getLectorsByNameTemplate(String template);
}
