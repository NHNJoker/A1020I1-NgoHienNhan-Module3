package model.service;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    String addNewEmployee(Employee employee) throws SQLException;

    List<Employee> showAll();

    List<Employee> search(String valueSearch);

    Employee showEmployee(int id);

    String edit(Employee employee) throws SQLException;

    Employee showEmployeeEdit(int id);

    boolean delete(int id) throws SQLException;
}
