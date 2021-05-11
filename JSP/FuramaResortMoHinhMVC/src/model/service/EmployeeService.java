package model.service;

import model.bean.Employee;

import java.sql.SQLDataException;
import java.util.List;

public interface EmployeeService {
    public void addNewEmployee(Employee employee) throws SQLDataException;
    public List<Employee> showAll();
}
