package model.service;

import model.bean.*;

import java.sql.SQLException;
import java.util.List;

public interface ContractService {
    List<Service> showAllService();

    List<Employee> showAllEmployee();

    List<Customer> showAllCus();

    void addNewContract(Contract contract)throws SQLException;

    List<ContractDetailAndCus> showAllContractDetail();

    List<AccompaniedService> showAllAccompaniedService();

    void addNewContractDetail(ContractDetail contractDetail)throws SQLException;

    Contract displayContractById(int idContract);

    ContractDetail displayContractDetailById(int idContract);

    ContractDetailAndCus showContractDetailUsedServiceById(int idContract);

    void editContract(Contract contract);

    void editContractDetail(ContractDetail contractDetail);

    void deleteContract(int idContract);

    void deleteContractDetail(int idContract);
}
