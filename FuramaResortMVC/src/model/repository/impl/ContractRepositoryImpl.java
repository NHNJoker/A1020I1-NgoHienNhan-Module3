package model.repository.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.repository.ContractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/database_furama?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Nhan0916309250@";

    private static final String SELECT_ALL_SERVICE = "select id_dich_vu, ten_dich_vu, dien_tich , so_tang , so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, link_anh\n" +
            "from dich_vu;";
    private static final String SELECT_ALL_EMPLOYEE = "select id_nhan_vien, ho_va_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, bo_phan.ten_bo_phan, vi_tri.ten_vi_tri, trinh_do.ten_trinh_do\n" +
            "from nhan_vien\n" +
            "left join vi_tri on vi_tri.id_vi_tri = nhan_vien.id_vi_tri\n" +
            "    left join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan\n" +
            "    left join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do";
    private static final String SELECT_ALL_CUS = "select id_khach_hang, ho_va_ten, ngay_sinh, so_cmnd, sdt, email, dia_chi, loai_khach.ten_loai_khach \n" +
            "from khach_hang\n" +
            "\tleft join loai_khach on\tloai_khach.id_loai_khach = khach_hang.id_loai_khach;";

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
    public List<Service> showAllService() {
        List<Service> serviceList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE)) {
            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                int areaUsed = resultSet.getInt("dien_tich");
                int numOfFloors = resultSet.getInt("so_tang");
                int maxPeople = resultSet.getInt("so_nguoi_toi_da");
                int rentalCost = resultSet.getInt("chi_phi_thue");
                String rentalType = String.valueOf(resultSet.getInt("id_kieu_thue"));
                String typeOfService = String.valueOf(resultSet.getInt("id_loai_dich_vu"));
                String linkImg = resultSet.getString("link_anh");

                serviceList.add(new Service(id, name, areaUsed, numOfFloors, maxPeople, rentalCost, rentalType, typeOfService, linkImg));

            }

        } catch (SQLException ex) {
            printSQLException(ex);
        }

        return serviceList;
    }

    @Override
    public List<Employee> showAllEmployee() {
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
                String level = rs.getString("trinh_do.ten_trinh_do");
                String position = rs.getString("vi_tri.ten_vi_tri");
                String workingParts = rs.getString("bo_phan.ten_bo_phan");
                String address = rs.getString("dia_chi");
                int salary = rs.getInt("luong");
                int idEmployee = rs.getInt("id_nhan_vien");
                employees.add(new Employee(idEmployee, name, date, email, id, phone, level, address, salary, position, workingParts));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public List<Customer> showAllCus() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUS);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCus = rs.getInt("id_khach_hang");
                String name = rs.getString("ho_va_ten");
                String date = rs.getString("ngay_sinh");
                String idCard = rs.getString("so_cmnd");
                String phone = rs.getString("sdt");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                String typeCus = rs.getString("ten_loai_khach");

                customers.add(new Customer(idCus, typeCus, name, date, idCard, phone, email, address));
            }
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return customers;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
