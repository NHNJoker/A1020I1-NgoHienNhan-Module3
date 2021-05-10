package model.service;

import model.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> showAll();
    boolean addNewEmployee(Employee employee);
}
