package model.bean;

public class Contract {
    private int idContract;
    private int idEmployee;
    private int idCus;
    private int idService;
    private String contractDate;
    private String contractEndDate;
    private int deposits;
    private int total;

    public Contract() {
    }

    public Contract(int idContract, int idEmployee, int idCus, int idService, String contractDate, String contractEndDate, int deposits, int total) {
        this.idContract = idContract;
        this.idEmployee = idEmployee;
        this.idCus = idCus;
        this.idService = idService;
        this.contractDate = contractDate;
        this.contractEndDate = contractEndDate;
        this.deposits = deposits;
        this.total = total;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getDeposits() {
        return deposits;
    }

    public void setDeposits(int deposits) {
        this.deposits = deposits;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
