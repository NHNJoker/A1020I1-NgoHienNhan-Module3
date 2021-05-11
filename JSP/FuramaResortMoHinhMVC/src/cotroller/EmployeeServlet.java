package cotroller;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.service.EmployeeService;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            if (actionUser.equals("addNewEmployee")) {
                String name = request.getParameter("nameEmployee");
                String date = request.getParameter("dateOfBirthEmployee");
                String id = request.getParameter("idEmployee");
                String phone = request.getParameter("phoneEmployee");
                String email = request.getParameter("emailEmployee");
                String level = request.getParameter("levelEmployee");
                String position = request.getParameter("positionEmployee");
                String workingParts = request.getParameter("workingPartEmployee");
                String address = request.getParameter("inputAddressEmployee");
                double salary = Double.parseDouble(request.getParameter("inputSalaryEmployee"));
                int idEmployee = (int) (Math.random() * 10000);

                Employee employee = new Employee(idEmployee, name, date, email, id, phone, level, address, salary, position, workingParts);

                this.employeeService.addNewEmployee(employee);
                request.setAttribute("employeeListServlet", this.employeeService.showAll());
                request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
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

        if (actionUser.equals("addNewEmployee")) {
            response.sendRedirect("addNewEmployee.jsp");
        }else if (actionUser.equals("displayEmployee")){
            request.setAttribute("employeeListServlet", employeeService.showAll());
            request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
        }
    }
}
