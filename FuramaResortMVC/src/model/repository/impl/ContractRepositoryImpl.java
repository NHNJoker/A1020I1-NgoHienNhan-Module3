package model.repository.impl;

import model.bean.*;
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
    private static final String SELECT_CONTRACT_AND_CUS = "select hop_dong.id_hop_dong ,khach_hang.ho_va_ten as ho_va_ten, ngay_lam_hop_dong, ngay_ket_thuc, dich_vu_di_kem.ten_dich_vu as ten_dich_vu, dich_vu_di_kem.gia_tien as gia_tien,tong_tien\n" +
            "from hop_dong\n" +
            "\tleft join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang\n" +
            "    left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong\n" +
            "    left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem;";
    private static final String INSERT_CONTRACT = "insert into hop_dong\n" +
            "values(?,?,?,?,?,?,?,?);";
    private static final String SELECT_ACCOMPANIED_SERVICE = "SELECT * FROM database_furama.dich_vu_di_kem;";
    private static final String INSERT_CONTRACT_DETAIL = "insert into hop_dong_chi_tiet\n" +
            "values(?,?,?,?);";
    private static final String SELECT_CONTRACT_BY_ID = "select *\n" +
            "    from hop_dong\n" +
            "    where id_hop_dong = ?;";
    private static final String SELECT_CONTRACT_DETAIL_BY_ID = "select*\n" +
            "from hop_dong_chi_tiet\n" +
            "where id_hop_dong = ?;";
    private static final String SELECT_CONTRACT_DETAIL_EDIT_BY_ID = "select nhan_vien.ho_va_ten as ten_nhan_vien,khach_hang.ho_va_ten as ho_va_ten,dich_vu.ten_dich_vu as ten_dich_vu , ngay_lam_hop_dong, ngay_ket_thuc, dich_vu_di_kem.ten_dich_vu as ten_dich_vu_di_kem, dich_vu_di_kem.gia_tien as gia_tien,tong_tien\n" +
            "from hop_dong\n" +
            "\tleft join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang\n" +
            "    left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong\n" +
            "    left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem\n" +
            "    left join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien\n" +
            "    left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu\n" +
            "    where hop_dong.id_hop_dong = ?;";
    private static final String UPDATE_CONTRACT = "update hop_dong\n" +
            "set id_nhan_vien = ? , id_khach_hang = ? , id_dich_vu = ?, ngay_lam_hop_dong = ? , ngay_ket_thuc = ? , tien_dat_coc = ?, tong_tien = ?\n" +
            "where id_hop_dong = ?;";
    private static final String UPDATE_CONTRACT_DETAIL = "update hop_dong_chi_tiet\n" +
            "set id_dich_vu_di_kem = ?,  so_luong = ?\n" +
            "where id_hop_dong = ?;";
    private static final String DELETE_CONTRACT = "delete\n" +
            "from hop_dong\n" +
            "where id_hop_dong = ?;";
    private static final String DELETE_CONTRACT_DETAIL = "delete\n" +
            "from hop_dong_chi_tiet\n" +
            "where id_hop_dong = ?;";

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

    @Override
    public List<ContractDetailAndCus> showContractDetail() {
        List<ContractDetailAndCus> contractDetailAndCuses = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_AND_CUS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idContract = rs.getInt("hop_dong.id_hop_dong");
                String nameCus = rs.getString("ho_va_ten");
                String startDate = rs.getString("ngay_lam_hop_dong");
                String endDate = rs.getString("ngay_ket_thuc");
                String nameService = rs.getString("ten_dich_vu");
                int priceService = rs.getInt("gia_tien");
                int total = rs.getInt("tong_tien");

                contractDetailAndCuses.add(new ContractDetailAndCus(idContract, nameCus, startDate, endDate, nameService, priceService, total));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractDetailAndCuses;
    }

    @Override
    public void addNewContract(Contract contract) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT)) {
            preparedStatement.setInt(1, contract.getIdContract());
            preparedStatement.setInt(2, contract.getIdEmployee());
            preparedStatement.setInt(3, contract.getIdCus());
            preparedStatement.setInt(4, contract.getIdService());
            preparedStatement.setString(5, contract.getContractDate());
            preparedStatement.setString(6, contract.getContractEndDate());
            preparedStatement.setInt(7, contract.getDeposits());
            preparedStatement.setInt(8, contract.getTotal());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            printSQLException(ex);
        }
    }

    @Override
    public List<AccompaniedService> showAllAccompaniedService() {
        List<AccompaniedService> accompaniedServices = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOMPANIED_SERVICE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_dich_vu_di_kem");
                String name = rs.getString("ten_dich_vu");
                int price = rs.getInt("gia_tien");

                accompaniedServices.add(new AccompaniedService(id, name, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return accompaniedServices;
    }

    @Override
    public void addNewContractDetail(ContractDetail contractDetail) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_CONTRACT_DETAIL)) {
            preparedStatement.setInt(1, contractDetail.getIdContractDetail());
            preparedStatement.setInt(2, contractDetail.getIdContract());
            preparedStatement.setInt(3, contractDetail.getIdAccompaniedService());
            preparedStatement.setInt(4, contractDetail.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Contract displayContractById(int idContract) {
        Contract contract = new Contract();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID)) {
            preparedStatement.setInt(1, idContract);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_hop_dong");
                int idCus = rs.getInt("id_khach_hang");
                int idEmployee = rs.getInt("id_nhan_vien");
                int idService = rs.getInt("id_dich_vu");
                String startDate = rs.getString("ngay_lam_hop_dong");
                String endDate = rs.getString("ngay_ket_thuc");
                int deposits = rs.getInt("tien_dat_coc");
                int total = rs.getInt("tong_tien");

                contract = new Contract(id, idEmployee, idCus, idService, startDate, endDate, deposits, total);

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contract;
    }

    @Override
    public ContractDetail displayContractDetailById(int idContract) {
        ContractDetail contractDetail = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL_BY_ID)) {
            preparedStatement.setInt(1, idContract);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_hop_dong");
                int idContractDetail = rs.getInt("id_hop_dong");
                int idAccompaniedService = rs.getInt("id_dich_vu_di_kem");
                int amount = rs.getInt("so_luong");

                contractDetail = new ContractDetail(idContractDetail, idAccompaniedService, id, amount);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return contractDetail;
    }

    @Override
    public ContractDetailAndCus showContractDetailUsedServiceById(int idContract) {
        ContractDetailAndCus contractDetailAndCus = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL_EDIT_BY_ID)){
            preparedStatement.setInt(1,idContract);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String nameEmployee = rs.getString("ten_nhan_vien");
                String nameCus = rs.getString("ho_va_ten");
                String nameService = rs.getString("ten_dich_vu");
                String startDate = rs.getString("ngay_lam_hop_dong");
                String endDate = rs.getString("ngay_ket_thuc");
                String nameAccompaniedService = rs.getString("ten_dich_vu_di_kem");
                int priceAccompaniedService = rs.getInt("gia_tien");
                int total = rs.getInt("tong_tien");

                contractDetailAndCus = new ContractDetailAndCus(nameEmployee,nameService,nameCus,startDate,endDate,nameAccompaniedService,priceAccompaniedService,total);

            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return contractDetailAndCus;
    }

    @Override
    public void editContract(Contract contract) {
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT)){
            preparedStatement.setInt(1,contract.getIdEmployee());
            preparedStatement.setInt(2,contract.getIdCus());
            preparedStatement.setInt(3,contract.getIdService());
            preparedStatement.setString(4,contract.getContractDate());
            preparedStatement.setString(5,contract.getContractEndDate());
            preparedStatement.setInt(6,contract.getDeposits());
            preparedStatement.setInt(7,contract.getTotal());
            preparedStatement.setInt(8,contract.getIdContract());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public void editContractDetail(ContractDetail contractDetail) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_DETAIL)){
            preparedStatement.setInt(1, contractDetail.getIdAccompaniedService());
            preparedStatement.setInt(2, contractDetail.getAmount());
            preparedStatement.setInt(3, contractDetail.getIdContract());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public void deleteContract(int idContract) {
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT)){
            preparedStatement.setInt(1, idContract);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public void deleteContractDetail(int idContract) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_DETAIL)){
            preparedStatement.setInt(1, idContract);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
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
