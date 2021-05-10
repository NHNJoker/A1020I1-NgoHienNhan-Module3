package model.repository;

import model.bean.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> showAll();
    boolean addNewEmployee(Employee employee);
}
