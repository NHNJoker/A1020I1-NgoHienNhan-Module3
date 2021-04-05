function home() {
    document.getElementById('titleHome').innerText = "Welcome to Furama resort";
    document.getElementById('show').innerText = '';
}
class Employee {
    constructor(name, birthday, id, phone, email, degree, position, salary) {
        this.employeeName = name;
        this.employeeBirthday = birthday;
        this.employeeIDCard = id;
        this.employeePhone = phone;
        this.employeeEmail = email;
        this.employeeDegreeID = degree;
        this.positionID = position;
        this.employeeSalary = salary;
    }

    setName(name) {
        this.employeeName = name;
    }

    getName() {
        return this.employeeName;
    }

    setBirthday(birthday) {
        this.employeeBirthday = birthday;
    }

    getBirthday() {
        return this.employeeBirthday;
    }

    setIdCard(id) {
        this.employeeDegreeID = id;
    }

    getIdCard() {
        return this.employeeDegreeID;
    }

    setPhone(phone) {
        this.employeePhone = phone;
    }

    getPhone() {
        return this.employeePhone;
    }

    setEmail(email) {
        this.employeeEmail = email;
    }

    getEmail() {
        return this.employeeEmail;
    }

    setDegree(degree) {
        this.employeeDegreeID = degree;
    }

    getDegree() {
        return this.employeeDegreeID;
    }

    setPosition(position) {
        this.positionID = position;
    }

    getPosition() {
        return this.positionID;
    }

    setSalary(salary) {
        this.employeeSalary = salary;
    }

    getSalary() {
        return this.employeeSalary;
    }
}

function addNewEmployee() {
    let formEmployee = "<h1>Nhập thông tin của nhân viên :</h1>\n" +
        "<form>\n" +
        "    <h3>Họ và tên\\Full name:</h3>\n" +
        "    <input type=\"text\" id=\"name\">\n" +
        "    <h3>CMND\\ID card:</h3>\n" +
        "    <input type=\"text\" id=\"id\">\n" +
        "    <h3>Ngày sinh\\Date of birth:</h3>\n" +
        "    <input type=\"text\" id=\"date\">\n" +
        "    <h3>Email:</h3>\n" +
        "    <input type=\"text\" id=\"email\">\n" +
        "    <h3>Trình độ\\Degree:</h3>\n" +
        "    <select id=\"degree\">\n" +
        "        <option value=\"Trung cấp\">Trung cấp</option>\n" +
        "        <option value=\"Cao đẳng\">Cao đẳng</option>\n" +
        "        <option value=\"Đại học\">Đại học</option>\n" +
        "        <option value=\"Sau đại học\">Sau đại học</option>\n" +
        "    </select>\n" +
        "    <br>\n" +
        "    <br>\n" +
        "    <h3>Vị trí\\Position:</h3>\n" +
        "    <select id=\"position\">\n" +
        "        <option value=\"Lễ tân\">Lễ tân</option>\n" +
        "        <option value=\"Phục vụ\">Phục vụ</option>\n" +
        "        <option value=\"Chuyên viên\">Chuyên viên</option>\n" +
        "        <option value=\"Giám sát\">Giám sát</option>\n" +
        "        <option value=\"Quản lý\">Quản lý</option>\n" +
        "        <option value=\"Giám đốc\">Giám đốc</option>\n" +
        "    </select>\n" +
        "    <br>\n" +
        "    <br>\n" +
        "    <h3>Bộ phận\\Division:</h3>\n" +
        "    <select id=\"division\">\n" +
        "        <option value=\"Sale - Marketing\">Sale - Marketing</option>\n" +
        "        <option value=\"Phục vụ\">Phục vụ</option>\n" +
        "        <option value=\"Hành chính\">Hành chính</option>\n" +
        "        <option value=\"Quản lý\">Quản lý</option>\n" +
        "    </select>\n" +
        "    <br>\n" +
        "    <br>\n" +
        "    <input type=\"reset\" value=\"Reset\">\n" +
        "</form>\n" +
        "<br>\n" +
        "<br>\n" +
        "<div class=\"button\">\n" +
        "        <a class=\"btn\" onclick=\"submit()\">Submit</a>\n" +
        "    </div>";
    document.getElementById('show').innerHTML = formEmployee;
}