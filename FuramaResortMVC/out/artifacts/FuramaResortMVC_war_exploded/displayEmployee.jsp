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
            <h3>Display employees</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Index</th>
                        <th scope="col">Full name</th>
                        <th scope="col">Date of birth</th>
                        <th scope="col">ID card</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Email</th>
                        <th scope="col">Academic level</th>
                        <th scope="col">Position</th>
                        <th scope="col">Working parts</th>
                        <th scope="col"></th>
                        <th scope="col"></th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${employeeListServlet}" varStatus="loop">
                        <tr>
                            <td scope="row"><c:out value="${loop.index +1}"/></td>
                            <td><c:out value="${employee.nameOfEmployee}"/></td>
                            <td><c:out value="${employee.dateOfBirth}"/></td>
                            <td><c:out value="${employee.id}"/></td>
                            <td><c:out value="${employee.phone}"/></td>
                            <td><c:out value="${employee.email}"/></td>
                            <td><c:out value="${employee.level}"/></td>
                            <td><c:out value="${employee.workPosition}"/></td>
                            <td><c:out value="${employee.workingParts}"/></td>
                            <td>
<%--                                <form action="/employee?actionUser=edit&idEmployee=${employee.idEmployee}">--%>
<%--                                    <button type="submit" class="btn btn-outline-primary">Edit</button>--%>
<%--                                </form>--%>
                                    <a href="/employee?actionUser=edit&idEmployee=${employee.idEmployee}">edit</a>
                            </td>
                            <td><button type="submit" class="btn btn-outline-primary">Delete</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
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
