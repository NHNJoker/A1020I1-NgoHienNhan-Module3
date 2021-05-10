package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository =new EmployeeRepositoryImpl();

    @Override
    public List<Employee> showAll() {
        return this.employeeRepository.showAll();
    }

    @Override
    public boolean addNewEmployee(Employee employee) {
        this.employeeRepository.addNewEmployee(employee);
        return false;
    }
}
