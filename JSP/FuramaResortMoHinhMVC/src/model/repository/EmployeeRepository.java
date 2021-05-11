package model.repository;

import model.bean.Employee;

import java.sql.SQLDataException;
import java.util.List;

public interface EmployeeRepository {
    public void addNewEmployee(Employee employee) throws SQLDataException;
    public List<Employee> showAll();
}
