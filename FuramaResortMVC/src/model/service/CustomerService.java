package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    String addNewCus(Customer customer) throws SQLException;

    List<Customer> showAll();

    List<Customer> search(String valueSearch);

    Customer showCusEdit(int id);

    String edit(Customer customer) throws SQLException;

    Customer showCus(int id);

    boolean delete(int id) throws SQLException;
}
