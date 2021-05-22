package model.repository;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;

import java.util.List;

public interface ContractRepository {
    List<Service> showAllService();

    List<Employee> showAllEmployee();

    List<Customer> showAllCus();
}
