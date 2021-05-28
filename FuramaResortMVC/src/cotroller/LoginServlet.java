package cotroller;

import model.bean.Account;
import model.service.LoginService;
import model.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }

        if (actionUser.equals("login")) {
            String userName = request.getParameter("userName");
            String pass = request.getParameter("pass");

            Account account = this.loginService.login(userName, pass);

            if (account == null) {
                request.setAttribute("userName", userName);
                request.setAttribute("msg", "Incorrect username or password. Please re-enter.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }

        if (actionUser.equals("logOut")){
            HttpSession session = request.getSession();
            session.removeAttribute("account");
            response.sendRedirect("index.jsp");
        }
    }
}
