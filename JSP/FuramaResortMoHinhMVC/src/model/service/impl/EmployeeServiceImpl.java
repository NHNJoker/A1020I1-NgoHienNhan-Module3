package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.sql.SQLDataException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository =new EmployeeRepositoryImpl();

    @Override
    public void addNewEmployee(Employee employee) throws SQLDataException {

    }

    @Override
    public List<Employee> showAll() {
        List<Employee> employees = this.employeeRepository.showAll();
        return employees;
    }
}
