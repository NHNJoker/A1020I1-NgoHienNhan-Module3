package cotroller;

import model.bean.Contract;
import model.service.ContractService;
import model.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet(name = "ContractServlet" , urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {

    ContractService contractService = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null){
            actionUser = "";
        }
        try{
            if (actionUser.equals("addNewContract")){
                int idCus = Integer.parseInt(request.getParameter("idCus"));
                int idEmployee = Integer.parseInt(request.getParameter("idEmployee"));
                int idService = Integer.parseInt(request.getParameter("idService"));
                String contractDate = request.getParameter("contractDate");
                String contractEndDate = request.getParameter("contractEndDate");
                int deposits = Integer.parseInt(request.getParameter("deposits"));
                int rentalCostsContract = Integer.parseInt(request.getParameter("rentalCostsContract"));

                DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                long getDaysDiff =
                        (simpleDateFormat.parse(contractEndDate).getTime()
                                - simpleDateFormat.parse(contractDate).getTime()) / (24 * 60 * 60 * 1000);
                int total = Math.toIntExact(deposits - (rentalCostsContract * getDaysDiff));
                int idContract = (int) (Math.random()*1000);

                Contract contract = new Contract(idContract,idEmployee,idCus,idService,contractDate,contractEndDate,deposits,total);

                this.contractService.addNewContract(contract);
                request.setAttribute("listContract", this.contractService.showAllContract());
                request.getRequestDispatcher("displayCustomerUsedService.jsp").forward(request,response);
            }
        }catch (Exception e){

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null){
            actionUser = "";
        }

        if (actionUser.equals("addNewContract")){
            request.setAttribute("listCus",this.contractService.showAllCus());
            request.setAttribute("listEmployee",this.contractService.showAllEmployee());
            request.setAttribute("listService",this.contractService.showAllService());
            request.getRequestDispatcher("addNewContract.jsp").forward(request,response);
        }
    }
}
