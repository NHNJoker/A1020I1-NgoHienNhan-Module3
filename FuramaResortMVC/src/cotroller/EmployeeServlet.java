package cotroller;

import model.bean.Employee;
import model.service.EmployeeService;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            switch (actionUser) {
                case "addNewEmployee":
                    addNewEmployeePost(request, response);
                    break;
                case "edit":
                    editEmployeePost(request, response);
                    break;
                case "search":
                    searchEmployee(request, response);
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
                case "addNewEmployee":
                    addNewEmployeeGet(response);
                    break;
                case "displayEmployee":
                    displayEmployeeGet(request, response);
                    break;
                case "edit": {
                    editEmployeeGet(request, response);
                    break;
                }
                case "delete": {
                    deleteEmployeeGet(request, response);
                    break;
                }
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        request.setAttribute("employeeListServlet", this.employeeService.search(search));
        request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
    }

    protected void addNewEmployeePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("nameEmployee");
        String date = request.getParameter("dateOfBirthEmployee");
        String id = request.getParameter("idEmployee");
        String phone = request.getParameter("phoneEmployee");
        String email = request.getParameter("emailEmployee");
        String level = request.getParameter("levelEmployee");
        String position = request.getParameter("positionEmployee");
        String workingParts = request.getParameter("workingPartEmployee");
        String address = request.getParameter("inputAddressEmployee");
        int salary = 0;
        if (!request.getParameter("inputSalaryEmployee").equals("")) {
            salary = Integer.parseInt(request.getParameter("inputSalaryEmployee"));
        }
        int idEmployee = (int) (Math.random() * 10000);
        Employee employee = new Employee(idEmployee, name, date, email, id, phone, level, address, salary, position, workingParts);

        if (this.employeeService.addNewEmployee(employee).equals("")) {
            request.setAttribute("msg", "successfully added new");
            request.setAttribute("employeeListServlet", this.employeeService.showAll());
            request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
        } else {
            String[] msg = this.employeeService.addNewEmployee(employee).split("-");

            request.setAttribute("name", name);
            request.setAttribute("date", date);
            request.setAttribute("idCard", id);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            request.setAttribute("salary", salary);

            request.setAttribute("msgName", msg[0]);
            request.setAttribute("msgDate", msg[1]);
            request.setAttribute("msgID", msg[2]);
            request.setAttribute("msgPhone", msg[3]);
            request.setAttribute("msgEmail", msg[4]);
            request.setAttribute("msgAddress", msg[5]);
            request.setAttribute("msgSalary", msg[6]);

            request.getRequestDispatcher("addNewEmployee.jsp").forward(request, response);
        }
    }

    protected void editEmployeePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("nameEmployee");
        String date = request.getParameter("dateOfBirthEmployee");
        String id = request.getParameter("idEmployee");
        String phone = request.getParameter("phoneEmployee");
        String email = request.getParameter("emailEmployee");
        String level = request.getParameter("levelEmployee");
        String position = request.getParameter("positionEmployee");
        String workingParts = request.getParameter("workingPartEmployee");
        String address = request.getParameter("inputAddressEmployee");
        int salary = Integer.parseInt(request.getParameter("inputSalaryEmployee"));
        int idEmployee = Integer.parseInt(request.getParameter("id"));

        Employee employee = new Employee(idEmployee, name, date, email, id, phone, level, address, salary, position, workingParts);

        if (this.employeeService.edit(employee).equals("")) {
            List<Employee> employeeList = new ArrayList<>();
            employeeList.add(this.employeeService.showEmployeeEdit(idEmployee));
            request.setAttribute("msg", "Update successful");
            request.setAttribute("employeeListServlet", employeeList);
            request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
        } else {
            String[] msg = this.employeeService.edit(employee).split("-");

            request.setAttribute("name", name);
            request.setAttribute("date", date);
            request.setAttribute("idCard", id);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            request.setAttribute("salary", salary);

            request.setAttribute("msgName", msg[0]);
            request.setAttribute("msgDate", msg[1]);
            request.setAttribute("msgID", msg[2]);
            request.setAttribute("msgPhone", msg[3]);
            request.setAttribute("msgEmail", msg[4]);
            request.setAttribute("msgAddress", msg[5]);
            request.setAttribute("msgSalary", msg[6]);

            request.getRequestDispatcher("formEdit.jsp").forward(request, response);
        }
    }

    protected void addNewEmployeeGet(HttpServletResponse response) throws IOException {
        response.sendRedirect("addNewEmployee.jsp");
    }

    protected void editEmployeeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idEmployee"));

        request.setAttribute("employeeServlet", this.employeeService.showEmployee(id));
        request.getRequestDispatcher("formEdit.jsp").forward(request, response);
    }

    protected void displayEmployeeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeeListServlet", this.employeeService.showAll());
        request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
    }

    protected void deleteEmployeeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("idEmployee"));
        this.employeeService.delete(id);
        List<Employee> employees = this.employeeService.showAll();
        request.setAttribute("employeeListServlet", employees);
        request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
    }
}
