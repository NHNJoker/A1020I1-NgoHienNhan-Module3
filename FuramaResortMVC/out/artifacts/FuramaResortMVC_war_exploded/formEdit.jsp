<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama resort</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
          integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
</head>
<body>
<!-- Navbar -->
<nav id="bg-nav" class="navbar navbar-expand-lg navbar-light bg-light">
    <!-- Container wrapper -->
    <div class="container-fluid">
        <!-- Navbar brand -->
        <a class="navbar-brand" href="/">
            <img src="img/logo.png" alt="">
        </a>

        <!-- Toggle button -->
        <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>
        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <!-- Left links -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <!-- Navbar dropdown -->
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdownEmployee"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        Employee
                    </a>
                    <!-- Dropdown menu -->
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownEmployee">
                        <li><a class="dropdown-item" href="#">Add new employee</a></li>
                        <li><a class="dropdown-item" href="#">Display employee</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdownCus"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        Customer
                    </a>
                    <!-- Dropdown menu -->
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownCus">
                        <li><a class="dropdown-item" href="#">Add new customer</a></li>
                        <li><a class="dropdown-item" href="#">Display customer</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdownServices"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        Service
                    </a>
                    <!-- Dropdown menu -->
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownServices">
                        <li><a class="dropdown-item" href="#">Add new service</a></li>
                        <li><a class="dropdown-item" href="#">Display service</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdownContract"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        Contract
                    </a>
                    <!-- Dropdown menu -->
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownContract">
                        <li><a class="dropdown-item" href="#">Add new contract</a></li>
                        <li><a class="dropdown-item" href="#">Add new contract detail</a></li>
                    </ul>
                </li>
            </ul>
            <!-- Left links -->
            <!-- Search form -->
            <form class="d-flex input-group w-auto">
                <input
                        type="search"
                        class="form-control btn-rounded"
                        placeholder="Search..."
                        aria-label="Search"
                />
                <button
                        class="btn btn-outline-primary border"
                        type="button"
                        data-mdb-ripple-color="dark"
                >
                    <i class="fas fa-search"></i>
                </button>
            </form>
            <a data-toggle="modal" data-target="#exampleModal" class="nav-link" href="#" data-mdb-toggle="tooltip"
               title="Login">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor"
                     class="bi bi-person-circle" viewBox="0 0 16 16">
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                    <path fill-rule="evenodd"
                          d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                </svg>
            </a>
        </div>
        <!-- Collapsible wrapper -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">LOGIN</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1"
                                       aria-describedby="emailHelp">
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with
                                    anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1">
                            </div>
                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                <label class="form-check-label" for="exampleCheck1">Check me out</label>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Container wrapper -->
</nav>
<!--Main nav-->
<!--Main Layout-->
<div class="container-fluid">
    <div class="row m-3">
        <div class="col-lg-12 text-center">
            <h3>Add new employees</h3>
            <p class="text-black">Please enter the information below.</p>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <form action="/employee?actionUser=addNewEmployee" method="post">
                <div class="form-group">
                    <label for="inputNameEmployee">Full name</label>
                    <input value="${employeeServlet.nameOfEmployee}" type="text" class="form-control" id="inputNameEmployee" name="nameEmployee">
                </div>
                <div class="form-group">
                    <label for="inputDateOfBirth">Date of birth</label>
                    <input value="${employeeServlet.dateOfBirth}" type="date" class="form-control" id="inputDateOfBirth" name="dateOfBirthEmployee">
                </div>
                <div class="form-group">
                    <label for="inputID">ID card</label>
                    <input value="${employeeServlet.id}" type="text" class="form-control" id="inputID" name="idEmployee">
                </div>
                <div class="form-group">
                    <label for="inputPhone">Phone</label>
                    <input value="${employeeServlet.phone}" type="text" class="form-control" id="inputPhone" name="phoneEmployee">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmailEmployee">Email address</label>
                    <input value="${employeeServlet.email}" type="email" class="form-control" id="exampleInputEmailEmployee" aria-describedby="emailHelpEmployee" name="emailEmployee">
                    <small id="emailHelpEmployee" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="inputAddressEmployee">Address</label>
                    <input value="${employeeServlet.address}" type="text" class="form-control" id="inputAddressEmployee" name="inputAddressEmployee">
                </div>
                <div class="form-group">
                    <label for="inputSalaryEmployee">Salary</label>
                    <input value="${employeeServlet.salary}" type="text" class="form-control" id="inputSalaryEmployee" name="inputSalaryEmployee">
                </div>
                <div class="form-group">
                    <label for="inputLevel">Academic level</label>
                    <select  class="form-control form-select" id="inputLevel" name="levelEmployee">
                        <option ${employeeServlet.level == "1" ? 'selected="selected"' : ''} value="1">Intermediate</option>
                        <option ${employeeServlet.level == "2" ? 'selected="selected"' : ''} value="2">College</option>
                        <option ${employeeServlet.level == "3" ? 'selected="selected"' : ''} value="3">University</option>
                        <option ${employeeServlet.level == "4" ? 'selected="selected"' : ''} value="4">Postgraduate</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputPosition">Position</label>
                    <select class="form-control form-select" id="inputPosition" name="positionEmployee">
                        <option ${employeeServlet.workPosition == "1" ? 'selected="selected"' : ''} value="1">Receptionist</option>
                        <option ${employeeServlet.workPosition == "2" ? 'selected="selected"' : ''} value="2">Waitress</option>
                        <option ${employeeServlet.workPosition == "3" ? 'selected="selected"' : ''} value="3">Specialist</option>
                        <option ${employeeServlet.workPosition == "4" ? 'selected="selected"' : ''} value="4">Supervisor</option>
                        <option ${employeeServlet.workPosition == "5" ? 'selected="selected"' : ''} value="5">Manager</option>
                        <option ${employeeServlet.workPosition == "6" ? 'selected="selected"' : ''} value="6">Director</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputWorkingPart">Working parts</label>
                    <select class="form-control form-select" id="inputWorkingPart" name="workingPartEmployee">
                        <option ${employeeServlet.workingParts == "1" ? 'selected="selected"' : ''} value="1">Sale – Marketing</option>
                        <option ${employeeServlet.workingParts == "2" ? 'selected="selected"' : ''} value="2">Administration</option>
                        <option ${employeeServlet.workingParts == "3" ? 'selected="selected"' : ''} value="3">Services</option>
                        <option ${employeeServlet.workingParts == "4" ? 'selected="selected"' : ''} value="4">Management</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col-lg-3"></div>
    </div>
</div>
<!--Main Layout-->
<!--js-->
<script src="js/jquery-3.6.0.min.js "></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/mdb.min.js"></script>
<!--js-->
</body>
</html>