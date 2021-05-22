package model.service.impl;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.repository.ContractRepository;
import model.repository.impl.ContractRepositoryImpl;
import model.service.ContractService;

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
}
