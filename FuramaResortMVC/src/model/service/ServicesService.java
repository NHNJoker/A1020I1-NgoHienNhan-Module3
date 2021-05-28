package model.service;

import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServicesService {
    List<Service> displayPagination(int index);

    List<Service> displayPaginationBySearch(String valueSearch,int index);

    List<Service> showAll();

    List<Service> search(String valueSearch);

    String addNewService(Service service)throws SQLException;

    Service showServiceByID(int id);

    boolean deleteService(int id)throws SQLException;

    String editService(Service service)throws SQLException;
}
