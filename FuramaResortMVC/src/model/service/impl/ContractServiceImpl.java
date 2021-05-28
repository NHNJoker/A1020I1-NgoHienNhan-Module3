package model.service.impl;

import model.bean.*;
import model.repository.ContractRepository;
import model.repository.impl.ContractRepositoryImpl;
import model.service.ContractService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public List<Service> showAllService() {
        return this.contractRepository.showAllService();
    }

    @Override
    public List<Employee> showAllEmployee() {
        return this.contractRepository.showAllEmployee();
    }

    @Override
    public List<Customer> showAllCus() {
        return this.contractRepository.showAllCus();
    }

    @Override
    public void addNewContract(Contract contract) throws SQLException {
        this.contractRepository.addNewContract(contract);
    }

    @Override
    public List<ContractDetailAndCus> showAllContractDetail() {
        return this.contractRepository.showContractDetail();
    }

    @Override
    public List<AccompaniedService> showAllAccompaniedService() {
        return this.contractRepository.showAllAccompaniedService();
    }

    @Override
    public void addNewContractDetail(ContractDetail contractDetail) throws SQLException {
        this.contractRepository.addNewContractDetail(contractDetail);
    }

    @Override
    public Contract displayContractById(int idContract) {
        return this.contractRepository.displayContractById(idContract);
    }

    @Override
    public ContractDetail displayContractDetailById(int idContract) {
        return this.contractRepository.displayContractDetailById(idContract);
    }

    @Override
    public ContractDetailAndCus showContractDetailUsedServiceById(int idContract) {
        return this.contractRepository.showContractDetailUsedServiceById(idContract);
    }

    @Override
    public void editContract(Contract contract) {
        this.contractRepository.editContract(contract);
    }

    @Override
    public void editContractDetail(ContractDetail contractDetail) {
        this.contractRepository.editContractDetail(contractDetail);
    }

    @Override
    public void deleteContract(int idContract) {
        this.contractRepository.deleteContract(idContract);
    }

    @Override
    public void deleteContractDetail(int idContract) {
        this.contractRepository.deleteContractDetail(idContract);
    }
}
