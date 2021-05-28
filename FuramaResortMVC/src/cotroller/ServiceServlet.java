package cotroller;

import model.bean.Service;
import model.service.ServicesService;
import model.service.impl.ServicesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.regex.Pattern;


@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
@MultipartConfig(
        fileSizeThreshold = 2097152,
        maxFileSize = 10485760L,
        maxRequestSize = 52428800L
)

public class ServiceServlet extends HttpServlet {

    ServicesService servicesService = new ServicesServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            switch (actionUser) {
                case "addNewService":
                    addNewServicePost(request, response);
                    break;
                case "edit":
                    editServicePost(request, response);
                    break;
                case "search":
                    searchService(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        int id = 0;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        if (actionUser == null) {
            actionUser = "";
        }
        try {
            switch (actionUser) {
                case "addNewService":
                    addNewServiceGet(response);
                    break;
                case "displayService":
                    displayServiceGet(request, response);
                    break;
                case "displayServiceDetail":
                    displayDetailServiceGet(request, response, id);
                    break;
                case "edit":
                    editServiceGet(request, response, id);
                    break;
                case "delete":
                    deleteServiceGet(request, response, id);
                    break;
                case "search":
                    searchService(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void addNewServicePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String imgFileName = uploadImg(request);
        String name = request.getParameter("nameService");
        int areaUsed;
        if (!Pattern.matches("^[0-9]+$", request.getParameter("areaUsed"))) {
            areaUsed = 0;
        } else {
            areaUsed = Integer.parseInt(request.getParameter("areaUsed"));
        }
        int numberOfFloors;
        if (!Pattern.matches("^[0-9]+$", request.getParameter("numberOfFloors"))) {
            numberOfFloors = 0;
        } else {
            numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        }
        int maxPeople;
        if (!Pattern.matches("^[0-9]+$", request.getParameter("maxPeople"))) {
            maxPeople = 0;
        } else {
            maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        }
        int rentalCosts;
        if (!Pattern.matches("^[0-9]+$", request.getParameter("rentalCosts"))) {
            rentalCosts = 0;
        } else {
            rentalCosts = Integer.parseInt(request.getParameter("rentalCosts"));
        }
        String rentalType = request.getParameter("rentalType");
        String typeOfService = request.getParameter("typeOfService");
        int id = (int) (Math.random() * 1000);
        String linkImg = "imageService/" + imgFileName;

        Service service = new Service(id, name, areaUsed, numberOfFloors, maxPeople, rentalCosts, rentalType, typeOfService, linkImg);

        if (this.servicesService.addNewService(service).equals("")) {
            showServiceByPagination(request, response);
        } else {
            String[] msg = this.servicesService.addNewService(service).split("-");
            request.setAttribute("name", name);
            request.setAttribute("areaUsed", areaUsed);
            request.setAttribute("numberOfFloors", numberOfFloors);
            request.setAttribute("maxPeople", maxPeople);
            request.setAttribute("rentalCosts", rentalCosts);
            request.setAttribute("imgFileName", imgFileName);

            request.setAttribute("msgName", msg[0]);
            request.setAttribute("msgArea", msg[1]);
            request.setAttribute("msgFloor", msg[2]);
            request.setAttribute("msgMaxPeople", msg[3]);
            request.setAttribute("msgRentalCosts", msg[4]);
            request.setAttribute("msgUpload", msg[5]);

            request.getRequestDispatcher("addNewService.jsp").forward(request, response);
        }

    }

    protected void editServicePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String linkImg;
        if (uploadImg(request) != null) {
            linkImg = "imageService/" + uploadImg(request);
        } else {
            linkImg = request.getParameter("img");
        }

        int areaUsed;
        if (!Pattern.matches("^[0-9]+$", request.getParameter("areaUsed"))) {
            areaUsed = 0;
        } else {
            areaUsed = Integer.parseInt(request.getParameter("areaUsed"));
        }
        int numberOfFloors;
        if (!Pattern.matches("^[0-9]+$", request.getParameter("numberOfFloors"))) {
            numberOfFloors = 0;
        } else {
            numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        }
        int maxPeople;
        if (!Pattern.matches("^[0-9]+$", request.getParameter("maxPeople"))) {
            maxPeople = 0;
        } else {
            maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        }
        int rentalCosts;
        if (!Pattern.matches("^[0-9]+$", request.getParameter("rentalCosts"))) {
            rentalCosts = 0;
        } else {
            rentalCosts = Integer.parseInt(request.getParameter("rentalCosts"));
        }

        String name = request.getParameter("nameService");
        String rentalType = request.getParameter("rentalType");
        String typeOfService = request.getParameter("typeOfService");
        int id = Integer.parseInt(request.getParameter("id"));

        Service service = new Service(id, name, areaUsed, numberOfFloors, maxPeople, rentalCosts, rentalType, typeOfService, linkImg);
        if (this.servicesService.editService(service).equals("")) {
            showServiceByPagination(request, response);
        } else {
            String[] msg = this.servicesService.addNewService(service).split("-");
            request.setAttribute("name", name);
            request.setAttribute("areaUsed", areaUsed);
            request.setAttribute("numberOfFloors", numberOfFloors);
            request.setAttribute("maxPeople", maxPeople);
            request.setAttribute("rentalCosts", rentalCosts);
            request.setAttribute("imgFileName", request.getParameter("img"));

            request.setAttribute("msgName", msg[0]);
            request.setAttribute("msgArea", msg[1]);
            request.setAttribute("msgFloor", msg[2]);
            request.setAttribute("msgMaxPeople", msg[3]);
            request.setAttribute("msgRentalCosts", msg[4]);
            request.setAttribute("msgUpload", msg[5]);

            request.getRequestDispatcher("formEditService.jsp").forward(request, response);
        }

    }

    protected void searchService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        int count = this.servicesService.search(search).size();
        int pageSize = 3;
        int endPage = count / pageSize;
        if (count % pageSize != 0) {
            endPage++;
        }
        int index;
        if (request.getParameter("index") == null) {
            index = 1;
        } else {
            index = Integer.parseInt(request.getParameter("index"));
        }

        if (index == 0) {
            index = 1;
        }
        if (index > endPage) {
            index = endPage;
        }
        request.setAttribute("sizeTableSearch", count);
        request.setAttribute("search",search);
        request.setAttribute("msgPagination","search");
        request.setAttribute("index", index);
        request.setAttribute("endPage", endPage);
        request.setAttribute("listService", this.servicesService.displayPaginationBySearch(search, index));
        request.getRequestDispatcher("displayService.jsp").forward(request, response);
    }

    protected void addNewServiceGet(HttpServletResponse response) throws IOException {
        response.sendRedirect("addNewService.jsp");
    }

    protected void displayServiceGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showServiceByPagination(request, response);
    }

    protected void displayDetailServiceGet(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
        request.setAttribute("detailService", this.servicesService.showServiceByID(id));
        request.getRequestDispatcher("displayDetailService.jsp").forward(request, response);
    }

    protected void editServiceGet(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
        request.setAttribute("detailService", this.servicesService.showServiceByID(id));
        request.getRequestDispatcher("formEditService.jsp").forward(request, response);
    }

    protected void deleteServiceGet(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException, SQLException {
        this.servicesService.deleteService(id);
        request.setAttribute("msg", "successfully deleted");
        showServiceByPagination(request, response);
    }

    protected void showServiceByPagination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = this.servicesService.showAll().size();
        int pageSize = 3;
        int endPage = count / pageSize;
        if (count % pageSize != 0) {
            endPage++;
        }
        int index;
        if (request.getParameter("index") == null) {
            index = 1;
        } else {
            index = Integer.parseInt(request.getParameter("index"));
        }

        if (index == 0) {
            index = 1;
        }
        if (index > endPage) {
            index = endPage;
        }
        request.setAttribute("sizeTableDisplayAll", count);
        request.setAttribute("msgPagination", "displayAll");
        request.setAttribute("index", index);
        request.setAttribute("endPage", endPage);
        request.setAttribute("listService", this.servicesService.displayPagination(index));
        request.getRequestDispatcher("displayService.jsp").forward(request, response);
    }

    protected String uploadImg(HttpServletRequest request) {
        String imgFileName = null;
        try {
            //        luu du lieu vao thu muc /upload
            String uploadFolder = request.getServletContext().getRealPath("/imageService");
            Path uploadPath = Paths.get(uploadFolder);

            // neu thu muc chua ton tai thi tao moi
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // lay du lieu nguoi dung up load toi server
            Part imgPart = request.getPart("linkImg");

            //tra ve ten file nguoi dung up load du lieu

            imgFileName = Paths.get(imgPart.getSubmittedFileName()).getFileName().toString();

            imgPart.write(Paths.get(uploadPath.toString(), imgFileName).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgFileName;
    }
}
