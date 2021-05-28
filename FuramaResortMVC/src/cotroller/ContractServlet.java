package cotroller;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.service.ContractService;
import model.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {

    ContractService contractService = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            switch (actionUser) {
                case "addNewContract":
                    addNewContractPost(request, response);
                    break;
                case "addNewServiceDetail":
                    addNewContractDetailPost(request, response);
                    break;
                case "edit":
                    editPost(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "addNewContract":
                addNewContractGet(request, response);
                break;
            case "addNewContractDetail":
                addNewContractDetailGet(request, response);
                break;
            case "display":
                displayGet(request, response);
                break;
            case "edit":
                editGet(request, response);
                break;
            case "delete":
                deleteGet(request, response);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + actionUser);
        }
    }

    protected void addNewContractPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, ServletException, SQLException {
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
        int total = Math.toIntExact((rentalCostsContract * getDaysDiff) - deposits);
        int idContract = (int) (Math.random() * 1000);

        Contract contract = new Contract(idContract, idEmployee, idCus, idService, contractDate, contractEndDate, deposits, total);

        this.contractService.addNewContract(contract);
        request.setAttribute("listContract", this.contractService.showAllContractDetail());
        request.getRequestDispatcher("displayCusUsedService.jsp").forward(request, response);
    }

    protected void addNewContractDetailPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int idContract = Integer.parseInt(request.getParameter("idContract"));
        int idAccompaniedService = Integer.parseInt(request.getParameter("idAccompaniedService"));
        int idContractDetail = (int) (Math.random() * 10000);
        int amount = Integer.parseInt(request.getParameter("amount"));

        ContractDetail contractDetail = new ContractDetail(idContractDetail, idAccompaniedService, idContract, amount);

        this.contractService.addNewContractDetail(contractDetail);

        request.setAttribute("listContract", this.contractService.showAllContractDetail());
        request.getRequestDispatcher("displayCusUsedService.jsp").forward(request, response);
    }

    protected void editPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, ServletException, SQLException {
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
        int total = Math.toIntExact((rentalCostsContract * getDaysDiff) - deposits);
        int idContract = Integer.parseInt(request.getParameter("idContract"));

        Contract contract = new Contract(idContract, idEmployee, idCus, idService, contractDate, contractEndDate, deposits, total);

        this.contractService.editContract(contract);

        if (request.getParameter("idContractDetail") == null) {
            int idAccompaniedService = Integer.parseInt(request.getParameter("idAccompaniedService"));
            int idContractDetail = (int) (Math.random() * 10000);
            int amount = Integer.parseInt(request.getParameter("amount"));

            ContractDetail contractDetail = new ContractDetail(idContractDetail, idAccompaniedService, idContract, amount);

            this.contractService.addNewContractDetail(contractDetail);
        } else {
            int idAccompaniedService = Integer.parseInt(request.getParameter("idAccompaniedService"));
            int idContractDetail = Integer.parseInt(request.getParameter("idContractDetail"));
            int amount = Integer.parseInt(request.getParameter("amount"));

            ContractDetail contractDetail = new ContractDetail(idContractDetail, idAccompaniedService, idContract, amount);

            this.contractService.editContractDetail(contractDetail);
        }
        request.setAttribute("listContract", this.contractService.showAllContractDetail());
        request.getRequestDispatcher("displayCusUsedService.jsp").forward(request, response);
    }

    protected void addNewContractGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCus", this.contractService.showAllCus());
        request.setAttribute("listEmployee", this.contractService.showAllEmployee());
        request.setAttribute("listService", this.contractService.showAllService());
        request.getRequestDispatcher("addNewContract.jsp").forward(request, response);
    }

    protected void addNewContractDetailGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listAccompainedService", this.contractService.showAllAccompaniedService());
        request.setAttribute("listContract", this.contractService.showAllContractDetail());
        request.getRequestDispatcher("addNewContractDetail.jsp").forward(request, response);
    }

    protected void displayGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listContract", this.contractService.showAllContractDetail());
        request.getRequestDispatcher("displayCusUsedService.jsp").forward(request, response);
    }

    protected void editGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idContract = Integer.parseInt(request.getParameter("idContract"));

        request.setAttribute("listCus", this.contractService.showAllCus());
        request.setAttribute("listEmployee", this.contractService.showAllEmployee());
        request.setAttribute("listService", this.contractService.showAllService());
        request.setAttribute("listAccompaniedService", this.contractService.showAllAccompaniedService());
        request.setAttribute("listContractEdit", this.contractService.displayContractById(idContract));
        request.setAttribute("listContractDetailEdit", this.contractService.displayContractDetailById(idContract));
        request.setAttribute("listContract", this.contractService.showContractDetailUsedServiceById(idContract));
        request.getRequestDispatcher("formEditContract.jsp").forward(request, response);
    }

    private void deleteGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int idContract = Integer.parseInt(request.getParameter("idContract"));

        this.contractService.deleteContract(idContract);
        this.contractService.deleteContractDetail(idContract);

        request.setAttribute("listContract", this.contractService.showAllContractDetail());
        request.getRequestDispatcher("displayCusUsedService.jsp").forward(request, response);
    }
}
