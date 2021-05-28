package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.repository.impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public String addNewCus(Customer customer) throws SQLException {
        int check = 0;
        String msg = "";
        if (!validateName(customer.getNameCus())) {
            msg += "Client Name must capitalize first letter of each word.(Ex:Nguyen Van A)-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateDate(customer.getDateOfBirth())) {
            msg += "Year of birth must be greater than 1900 and less than 18 years from.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateIDCard(customer.getIdCard())) {
            msg += "The Id Card must have 9 digits and be in the format XXX XXX XXX.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validatePhone(customer.getPhone())) {
            msg += "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateEmail(customer.getEmail())) {
            msg += "Email must be in the correct format abc@abc.abc.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateAddress(customer.getAddress())) {
            msg += "Please enter the address.-";
        } else {
            check += 1;
            msg += " -";
        }

        if (check == 6) {
            this.customerRepository.addNewCus(customer);
            msg = "";
        }
        return msg;
    }

    @Override
    public List<Customer> showAll() {
        List<Customer> customers = this.customerRepository.showAll();
        return customers;
    }

    @Override
    public List<Customer> search(String valueSearch) {
        return this.customerRepository.search(valueSearch);
    }

    @Override
    public Customer showCusEdit(int id) {
        return this.customerRepository.showCusEdit(id);
    }

    @Override
    public String edit(Customer customer) throws SQLException {
        int check = 0;
        String msg = "";
        if (!validateName(customer.getNameCus())) {
            msg += "Client Name must capitalize first letter of each word.(Ex:Nguyen Van A)-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateDate(customer.getDateOfBirth())) {
            msg += "Year of birth must be greater than 1900 and less than 18 years from.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateIDCard(customer.getIdCard())) {
            msg += "The Id Card must have 9 digits and be in the format XXX XXX XXX.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validatePhone(customer.getPhone())) {
            msg += "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateEmail(customer.getEmail())) {
            msg += "Email must be in the correct format abc@abc.abc.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateAddress(customer.getAddress())) {
            msg += "Please enter the address.-";
        } else {
            check += 1;
            msg += " ";
        }

        if (check == 6) {
            this.customerRepository.edit(customer);
            msg = "";
        }
        return msg;
    }

    @Override
    public Customer showCus(int id) {
        return this.customerRepository.showCus(id);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        this.customerRepository.delete(id);
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
}
