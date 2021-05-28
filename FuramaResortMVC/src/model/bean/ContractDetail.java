package model.bean;

public class ContractDetail {
    private int idContractDetail;
    private int idAccompaniedService;
    private int idContract;
    private int amount;

    public ContractDetail() {
    }

    public ContractDetail(int idContractDetail, int idAccompaniedService, int idContract, int amount) {
        this.idContractDetail = idContractDetail;
        this.idAccompaniedService = idAccompaniedService;
        this.idContract = idContract;
        this.amount = amount;
    }

    public int getIdContractDetail() {
        return idContractDetail;
    }

    public void setIdContractDetail(int idContractDetail) {
        this.idContractDetail = idContractDetail;
    }

    public int getIdAccompaniedService() {
        return idAccompaniedService;
    }

    public void setIdAccompaniedService(int idAccompaniedService) {
        this.idAccompaniedService = idAccompaniedService;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
