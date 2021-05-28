package model.bean;

public class Account {
    private String userName;
    private String pass;
    private int isEmployee;
    private int isManager;

    public Account() {
    }

    public Account(String userName, String pass, int isEmployee, int isManager) {
        this.userName = userName;
        this.pass = pass;
        this.isEmployee = isEmployee;
        this.isManager = isManager;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(int isEmployee) {
        this.isEmployee = isEmployee;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }
}
