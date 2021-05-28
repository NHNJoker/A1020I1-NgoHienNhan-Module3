package model.repository;

import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServicesRepository {
    List<Service> displayPagination(int index);

    List<Service> displayPaginationBySearch(String valueSearch, int index);

    void addNewService(Service service) throws SQLException;

    List<Service> showAll();

    List<Service> searchService(String valueSearch);

    Service showServiceByID(int id);

    boolean deleteService(int id) throws SQLException;

    boolean editService(Service service) throws SQLException;
}
