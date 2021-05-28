package model.service.impl;

import model.bean.Service;
import model.repository.ServicesRepository;
import model.repository.impl.ServicesRepositoryImpl;
import model.service.ServicesService;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class ServicesServiceImpl implements ServicesService {
    ServicesRepository servicesRepository = new ServicesRepositoryImpl();

    @Override
    public List<Service> displayPagination(int index) {
        return this.servicesRepository.displayPagination(index);
    }

    @Override
    public List<Service> displayPaginationBySearch(String valueSearch,int index) {
        return this.servicesRepository.displayPaginationBySearch(valueSearch, index);
    }

    @Override
    public List<Service> showAll() {
        return this.servicesRepository.showAll();
    }

    @Override
    public List<Service> search(String valueSearch) {
        return this.servicesRepository.searchService(valueSearch);
    }

    @Override
    public String addNewService(Service service) throws SQLException {
        int check = 0;
        String msg = "";

        if (!validateName(service.getName())) {
            msg += "Please enter the name service.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(service.getAreaUsed())) {
            msg += "Please enter the area service.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(service.getNumOfFloors())) {
            msg += "Please enter the num of floors.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(service.getMaxPeoples())) {
            msg += "Please enter the max peoples.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(service.getRentalCosts())) {
            msg += "Please enter the rental costs.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateFileName(service.getLinkImg())) {
            msg += "Please upload the service image file.-";
        } else {
            check += 1;
            msg += " ";
        }

        if (check == 6) {
            this.servicesRepository.addNewService(service);
            msg = "";
        }

        return  msg;
    }

    @Override
    public Service showServiceByID(int id) {
        return this.servicesRepository.showServiceByID(id);
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return this.servicesRepository.deleteService(id);
    }

    @Override
    public String editService(Service service) throws SQLException {
        int check = 0;
        String msg = "";

        if (!validateName(service.getName())) {
            msg += "Please enter the name service.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(service.getAreaUsed())) {
            msg += "Please enter the area service.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(service.getNumOfFloors())) {
            msg += "Please enter the num of floors.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(service.getMaxPeoples())) {
            msg += "Please enter the max peoples.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateInteger(service.getRentalCosts())) {
            msg += "Please enter the rental costs.-";
        } else {
            check += 1;
            msg += "-";
        }

        if (!validateFileName(service.getLinkImg())) {
            msg += "Please upload the service image file.-";
        } else {
            check += 1;
            msg += " ";
        }

        if (check == 6) {
            this.servicesRepository.editService(service);
            msg = "";
        }

        return  msg;

    }

    private boolean validateInteger(int num) {
        if (num == 0) {
            return false;
        } else {
            return Pattern.matches("^[0-9]+$", String.valueOf(num));
        }
    }

    private boolean validateName(String name) {
        return name != null;
    }

    private boolean validateFileName(String fileName) {
        return !fileName.equals("imageService/");
    }
}
