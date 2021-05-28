package cotroller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            switch (actionUser) {
                case "addNewCus":
                    addNewCusPost(request, response);

                    break;
                case "edit":
                    editCusPost(request, response);
                    break;
                case "search":
                    searchCusPost(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }


        try {
            switch (actionUser) {
                case "addNewCustomer":
                    addNewCusGet(response);
                    break;
                case "displayCustomer":
                    displayCusGet(request, response);
                    break;
                case "edit": {
                    editCusGet(request, response);
                    break;
                }
                case "delete": {
                    deleteCusGet(request, response);
                    break;
                }
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void addNewCusPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String idTypeCus = request.getParameter("idTypeCus");
        String name = request.getParameter("inputNameCus");
        String date = request.getParameter("dateOfBirthCus");
        String idCard = request.getParameter("idCus");
        String phone = request.getParameter("phoneCus");
        String email = request.getParameter("emailCus");
        String address = request.getParameter("inputAddressCus");
        int idCus = (int) (Math.random() * 1000);
        Customer customer = new Customer(idCus, idTypeCus, name, date, idCard, phone, email, address);

        if (this.customerService.addNewCus(customer).equals("")) {
            request.setAttribute("msg", "successfully added new");
            request.setAttribute("listCus", this.customerService.showAll());
            request.getRequestDispatcher("displayCus.jsp").forward(request, response);
        } else {
            String[] msg = this.customerService.addNewCus(customer).split("-");

            request.setAttribute("name", name);
            request.setAttribute("date", date);
            request.setAttribute("idCard", idCard);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);

            request.setAttribute("msgName", msg[0]);
            request.setAttribute("msgDate", msg[1]);
            request.setAttribute("msgID", msg[2]);
            request.setAttribute("msgPhone", msg[3]);
            request.setAttribute("msgEmail", msg[4]);
            request.setAttribute("msgAddress", msg[5]);

            request.getRequestDispatcher("addNewCus.jsp").forward(request, response);
        }
    }

    protected void editCusPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String idTypeCus = request.getParameter("idTypeCus");
        String name = request.getParameter("inputNameCus");
        String date = request.getParameter("dateOfBirthCus");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phoneCus");
        String email = request.getParameter("emailCus");
        String address = request.getParameter("inputAddressCus");
        int idCus = Integer.parseInt(request.getParameter("idCus"));

        Customer customer = new Customer(idCus, idTypeCus, name, date, idCard, phone, email, address);

        if (this.customerService.edit(customer).equals("")) {
            List<Customer> customers = new ArrayList<>();
            customers.add(this.customerService.showCus(idCus));
            request.setAttribute("msg", "Update successful");
            request.setAttribute("listCus", customers);
            request.getRequestDispatcher("displayCus.jsp").forward(request, response);
        } else {
            String[] msg = this.customerService.edit(customer).split("-");

            request.setAttribute("name", name);
            request.setAttribute("date", date);
            request.setAttribute("idCard", idCard);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);

            request.setAttribute("msgName", msg[0]);
            request.setAttribute("msgDate", msg[1]);
            request.setAttribute("msgID", msg[2]);
            request.setAttribute("msgPhone", msg[3]);
            request.setAttribute("msgEmail", msg[4]);
            request.setAttribute("msgAddress", msg[5]);

            request.getRequestDispatcher("addNewCus.jsp").forward(request, response);
        }

    }

    protected void searchCusPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");

        request.setAttribute("listCus", this.customerService.search(search));
        request.getRequestDispatcher("displayCus.jsp").forward(request, response);
    }

    protected void addNewCusGet(HttpServletResponse response) throws IOException {
        response.sendRedirect("addNewCus.jsp");
    }

    protected void displayCusGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCus", this.customerService.showAll());
        request.getRequestDispatcher("displayCus.jsp").forward(request, response);
    }

    protected void editCusGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idCus"));

        request.setAttribute("listCus", this.customerService.showCusEdit(id));
        request.getRequestDispatcher("formEditCus.jsp").forward(request, response);
    }

    protected void deleteCusGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idCus"));
        this.customerService.delete(id);
        request.setAttribute("listCus", this.customerService.showAll());
        request.getRequestDispatcher("displayCus.jsp").forward(request, response);
    }
}
