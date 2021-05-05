package Sevrlet;

import Bean.Customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Sevrlet.Servlet", urlPatterns = {"/"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Object> listCustomer = new ArrayList<>();
        listCustomer.add(new Customers("Nguyen Van a","1999-06-11","Da nang", "/img/anh.png"));
        listCustomer.add(new Customers("Nguyen Van B","1993-03-11","Quang Ngai", "/img/anh.png"));
        listCustomer.add(new Customers("Nguyen Van C","1975-04-11","Quang Tri", "/img/anh.png"));
        listCustomer.add(new Customers("Nguyen Van D","1974-12-11","Ha noi", "/img/anh.png"));

        request.setAttribute("customer",listCustomer);
        request.getRequestDispatcher("list_customers.jsp").forward(request,response);
    }
}
