package com.korostenskyi.app.command;

import com.korostenskyi.app.data.dao.ContractDao;
import com.korostenskyi.app.data.dao.LectorDao;
import org.springframework.stereotype.Service;

@Service
public class CommandHandlerImpl implements CommandHandler {

    private String command;
    private ContractDao contractDao;

    @Override
    public String handleCommand(String command) {

        // List<String> wordList = Arrays.asList(command.split(" "));

        contractDao = new ContractDao();

        contractDao.getAll().forEach(contract -> System.out.println(contract.getDepartmentId()));

        return command;
    }
}
