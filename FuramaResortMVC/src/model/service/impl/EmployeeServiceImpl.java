package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.EmployeeService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public String addNewEmployee(Employee employee) throws SQLException {
        int check = 0;
        String msg = "";
        if (!validateName(employee.getNameOfEmployee())) {
            msg += "Client Name must capitalize first letter of each word.(Ex:Nguyen Van A)-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateDate(employee.getDateOfBirth())) {
            msg += "Year of birth must be greater than 1900 and less than 18 years from.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateIDCard(employee.getId())) {
            msg += "The Id Card must have 9 digits and be in the format XXX XXX XXX.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validatePhone(employee.getPhone())) {
            msg += "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateEmail(employee.getEmail())) {
            msg += "Email must be in the correct format abc@abc.abc.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateAddress(employee.getAddress())) {
            msg += "Please enter the address.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(employee.getSalary())) {
            msg += "Please enter the salary.-";
        } else {
            check += 1;
            msg += " ";
        }

        if (check == 7) {
            this.employeeRepository.addNewEmployee(employee);
            msg = "";
        }
        return msg;
    }

    @Override
    public List<Employee> showAll() {
        List<Employee> employees = this.employeeRepository.showAll();
        return employees;
    }

    @Override
    public List<Employee> search(String valueSearch) {
        return this.employeeRepository.search(valueSearch);
    }

    @Override
    public Employee showEmployee(int id) {
        return this.employeeRepository.showEmployee(id);
    }

    @Override
    public String edit(Employee employee) throws SQLException {

        int check = 0;
        String msg = "";
        if (!validateName(employee.getNameOfEmployee())) {
            msg += "Client Name must capitalize first letter of each word.(Ex:Nguyen Van A)-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateDate(employee.getDateOfBirth())) {
            msg += "Year of birth must be greater than 1900 and less than 18 years from.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateIDCard(employee.getId())) {
            msg += "The Id Card must have 9 digits and be in the format XXX XXX XXX.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validatePhone(employee.getPhone())) {
            msg += "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateEmail(employee.getEmail())) {
            msg += "Email must be in the correct format abc@abc.abc.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateAddress(employee.getAddress())) {
            msg += "Please enter the address.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(employee.getSalary())) {
            msg += "Please enter the salary.-";
        } else {
            check += 1;
            msg += " ";
        }

        if (check == 7) {
            this.employeeRepository.edit(employee);
            msg = "";
        }
        return msg;
    }

    @Override
    public Employee showEmployeeEdit(int id) {
        return this.employeeRepository.showEmployeeEdit(id);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        this.employeeRepository.delete(id);
        return false;
    }

    private boolean validateName(String name) {
        if (name == null) {
            return false;
        } else {
            return Pattern.matches("[A-Z][a-z]+([ ][A-Z][a-z]+|[ ][A-Z])+", name);
        }
    }

    private boolean validateEmail(String email) {
        if (email == null) {
            return false;
        } else {
            return Pattern.matches("([A-z]|[a-z]|[.])+[@][a-z]+([.][a-z]+){1,2}", email);
        }
    }

    private boolean validatePhone(String phone) {
        if (phone == null) {
            return false;
        } else {
            return Pattern.matches("^((091)|(090))[0-9]{7}$", phone);
        }
    }

    private boolean validateDate(String date) {
        if (date.equals("")) {
            return false;
        } else {
            String[] year = date.split("-");
            return ((Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(year[0])) >= 18);
        }
    }

    private boolean validateIDCard(String idCard) {
        if (idCard == null) {
            return false;
        } else {
            return Pattern.matches("^[0-9]{9}$", idCard);
        }
    }

    private boolean validateAddress(String address) {
        if (address.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateInteger(int num) {
        if (num == 0) {
            return false;
        } else {
            return Pattern.matches("^[0-9]+$", String.valueOf(num));
        }
    }
}
