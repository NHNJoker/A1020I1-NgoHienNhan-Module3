package model.service;

import model.bean.Contract;
import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ContractService {
    List<Service> showAllService();

    List<Employee> showAllEmployee();

    List<Customer> showAllCus();

    void addNewContract(Contract contract)throws SQLException;

    List<Contract> showAllContract();
    
}
