package com.korostenskyi.app.core.service.command;

import com.korostenskyi.app.core.data.dao.ContractDao;
import com.korostenskyi.app.core.data.dao.DepartmentDao;
import com.korostenskyi.app.core.data.dao.LectorDao;
import org.springframework.stereotype.Service;

@Service
public class CommandHandlerImpl implements CommandHandler {

    private String command;

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

        return command;
    }

    /**
     * Returns the name of the head of given department.
     *
     * @param departmentName The name of department
     * @return The name of the head of given department
     */
    private String getHeadOfDepartmentByDepartmentName(String departmentName) {
        return departmentDao.getHeadOfDepartmentByDepartmentName(departmentName);
    }
}
