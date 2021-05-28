package model.bean;

public class ContractDetailAndCus {

    private int idContract;
    private String nameEmployee;
    private String nameService;
    private String nameCus;
    private String startDate;
    private String endDate;
    private String nameAccompaniedService;
    private int priceAccompaniedService;
    private int total;

    public ContractDetailAndCus() {
    }

    public ContractDetailAndCus(String nameEmployee, String nameService, String nameCus, String startDate, String endDate, String nameAccompaniedService, int priceAccompaniedService, int total) {
        this.nameEmployee = nameEmployee;
        this.nameService = nameService;
        this.nameCus = nameCus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nameAccompaniedService = nameAccompaniedService;
        this.priceAccompaniedService = priceAccompaniedService;
        this.total = total;
    }

    public ContractDetailAndCus(int idContract, String nameCus, String startDate, String endDate, String nameAccompaniedService, int priceAccompaniedService, int total) {
        this.idContract = idContract;
        this.nameCus = nameCus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nameAccompaniedService = nameAccompaniedService;
        this.priceAccompaniedService = priceAccompaniedService;
        this.total = total;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNameAccompaniedService() {
        return nameAccompaniedService;
    }

    public void setNameAccompaniedService(String nameAccompaniedService) {
        this.nameAccompaniedService = nameAccompaniedService;
    }

    public int getPriceAccompaniedService() {
        return priceAccompaniedService;
    }

    public void setPriceAccompaniedService(int priceAccompaniedService) {
        this.priceAccompaniedService = priceAccompaniedService;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
