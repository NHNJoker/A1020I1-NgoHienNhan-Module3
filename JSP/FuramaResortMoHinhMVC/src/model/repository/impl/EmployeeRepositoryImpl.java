package model.repository.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeRepositoryImpl implements EmployeeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/database_furama?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Nhan0916309250@";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO nhan_vien" + "  (id_nhan_vien, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi) VALUES " +
            " (?, ?, ?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_EMPLOYEE = "select * from nhan_vien";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void addNewEmployee(Employee employee) throws SQLDataException {
        System.out.println(INSERT_EMPLOYEE_SQL);

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, String.valueOf(employee.getIdEmployee()));
            preparedStatement.setString(2, employee.getWorkPosition());
            preparedStatement.setString(3, employee.getLevel());
            preparedStatement.setString(4, employee.getWorkingParts());
            preparedStatement.setString(5, employee.getDateOfBirth());
            preparedStatement.setString(6, employee.getId());
            preparedStatement.setString(7, employee.getPhone());
            preparedStatement.setString(8, employee.getEmail());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setString(8, employee.getNameOfEmployee());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw new ServletException(e);
            } catch (ServletException servletException) {
                servletException.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> showAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Employee> employees = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ho_va_ten");
                String date = rs.getString("ngay_sinh");
                String id = rs.getString("so_cmnd");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String level = rs.getString("id_trinh_do");
                String position = rs.getString("id_vi_tri");
                String workingParts = rs.getString("id_bo_phan");
                String address = rs.getString("dia_chi");
                double salary = rs.getDouble("luong");
                int idEmployee = rs.getInt("id_nhan_vien");
                ;
                employees.add(new Employee(idEmployee, name, date, email, id, phone, level, address, salary, position, workingParts));
            }
        } catch (SQLException e) {
            try {
                throw new ServletException(e);
            } catch (ServletException servletException) {
                servletException.printStackTrace();
            }
        }
        return employees;
    }
}
