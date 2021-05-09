import javafx.application.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("firstOperand"));
        float secondOperand = Integer.parseInt(request.getParameter("secondOperand"));
        char operator = request.getParameter("operator").charAt(0);
        float result = Calculator.calculator(firstOperand, secondOperand, operator);

        request.setAttribute("firstOperand",firstOperand);
        request.setAttribute("secondOperand",secondOperand);
        request.setAttribute("operator",operator);
        request.setAttribute("result",result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
