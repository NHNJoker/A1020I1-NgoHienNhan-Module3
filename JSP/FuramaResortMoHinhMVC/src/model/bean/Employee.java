package model.bean;

public class Employee {
    private String nameOfEmployee;
    private String dateOfBirth;
    private String email;
    private String id;
    private String phone;
    private String level;
    private String workPosition;
    private String workingParts;

    public Employee(String nameOfEmployee, String dateOfBirth, String email, String id, String phone, String level, String workPosition, String workingParts) {
        this.nameOfEmployee = nameOfEmployee;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.id = id;
        this.phone = phone;
        this.level = level;
        this.workPosition = workPosition;
        this.workingParts = workingParts;
    }

    @Override
    public String toString() {
        return
                nameOfEmployee + ',' +
                        dateOfBirth + ',' +
                        email + ',' +
                        id +','+
                        phone +','+
                        level + ',' +
                        workPosition + ',' +
                        workingParts;
    }

    public String getNameOfEmployee() {
        return nameOfEmployee;
    }

    public void setNameOfEmployee(String nameOfEmployee) {
        this.nameOfEmployee = nameOfEmployee;
    }


    public String getWorkingParts() {
        return workingParts;
    }

    public void setWorkingParts(String workingParts) {
        this.workingParts = workingParts;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
