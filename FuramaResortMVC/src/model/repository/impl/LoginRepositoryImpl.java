package model.repository.impl;

import model.bean.Account;
import model.repository.LoginRepository;

import java.sql.*;

public class LoginRepositoryImpl implements LoginRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/database_furama?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Nhan0916309250@";

    private static final String SELECT_ACCOUNT = "select *\n" +
            "    from `account`\n" +
            "    where user_name = ?\n" +
            "    and pass = ?;";

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
    public Account login(String userName, String pass) {
        try (Connection connection  = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT)){
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,pass);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4));
            }

        }catch (SQLException e){
            printSQLException(e);
        }
        return null;
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
