package model.repository.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static Map<Integer, Employee> employeeMap =new TreeMap<>();

    @Override
    public List<Employee> showAll() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public boolean addNewEmployee(Employee employee) {
        employeeMap.put(Integer.parseInt(employee.getId()), employee);
        return false;
    }
}
