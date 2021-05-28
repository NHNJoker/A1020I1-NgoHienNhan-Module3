<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <a class="navbar-brand" href="home.jsp">
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
                    <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
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
                        <li><a class="dropdown-item" href="/employee?actionUser=addNewEmployee">Add new employee</a>
                        </li>
                        <li><a class="dropdown-item" href="/employee?actionUser=displayEmployee">Display employee</a>
                        </li>
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
                        <li><a class="dropdown-item" href="/customer?actionUser=addNewCustomer">Add new customer</a>
                        </li>
                        <li><a class="dropdown-item" href=/customer?actionUser=displayCustomer">Display customer</a>
                        </li>
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
                        <li><a class="dropdown-item" href="/service?actionUser=addNewService">Add new service</a></li>
                        <li><a class="dropdown-item" href="/service?actionUser=displayService">Display service</a></li>
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
                        <li><a class="dropdown-item" href="/contract?actionUser=addNewContract">Add new contract</a>
                        </li>
                        <li><a class="dropdown-item" href="/contract?actionUser=addNewContractDetail">Add new contract
                            detail</a></li>
                        <li><a class="dropdown-item" href="/contract?actionUser=display">Display contract
                            detail</a></li>
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
            <a class="nav-link" href="/login?actionUser=logOut" data-mdb-toggle="tooltip" data-bs-placement="bottom"
               title="Log out ${sessionScope.account.userName}">
                Log out
            </a>
        </div>
    </div>
</nav>
<!--Main nav-->
<!--Main Layout-->
<div class="container-fluid">
    <div class="row m-3">
        <div class="col-lg-12 text-center">
            <h3>Edit contract</h3>
            <p class="text-black">Please enter the information below.</p>
        </div>
    </div>
    <dl class="row">
        <div class="col-xl-3"></div>
        <dt class="col-xl-2">Full name customer:</dt>
        <dd id="nameCus" class="col-xl-3"><c:out value="${listContract.nameCus}"></c:out></dd>
        <button onclick="displayEditCus()" class="col-xl-1 btn btn-outline-primary">
            <i class="far fa-edit"></i>
        </button>
    </dl>
    <div id="displayTableCus" class="row">
        <div class="col-lg-12">
            <table id="tableCus" class="table table-striped table-bordered" style="width: 100%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Index</th>
                    <th scope="col">Full name</th>
                    <th scope="col">Date of birth</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${listCus}" varStatus="loop">
                    <tr>
                        <td scope="row"><c:out value="${loop.index +1}"/></td>
                        <td><c:out value="${customer.nameCus}"/></td>
                        <td><c:out value="${customer.dateOfBirth}"/></td>
                        <td><c:out value="${customer.phone}"/></td>
                        <td><c:out value="${customer.email}"/></td>
                        <td>
                            <button onclick="chooseCus('${customer.idCus}','${customer.nameCus}')"
                                    class="btn btn-outline-primary">
                                Choose
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <dl class="row">
        <div class="col-xl-3"></div>
        <dt class="col-xl-2">Full name employee:</dt>
        <dd id="nameEmployee" class="col-xl-3"><c:out value="${listContract.nameEmployee}"></c:out></dd>
        <button onclick="displayEditEmployee()" class="col-xl-1 btn btn-outline-primary">
            <i class="far fa-edit"></i>
        </button>
    </dl>
    <div id="displayTableEmployee" class="row">
        <div class="col-lg-12">
            <table id="tableEmployee" class="table table-striped table-bordered" style="width: 100%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Index</th>
                    <th scope="col">Full name</th>
                    <th scope="col">Date of birth</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${listEmployee}" varStatus="loop">
                    <tr>
                        <td scope="row"><c:out value="${loop.index +1}"/></td>
                        <td><c:out value="${employee.nameOfEmployee}"/></td>
                        <td><c:out value="${employee.dateOfBirth}"/></td>
                        <td><c:out value="${employee.phone}"/></td>
                        <td><c:out value="${employee.email}"/></td>
                        <td>
                            <button onclick="chooseEmployee('${employee.idEmployee}','${employee.nameOfEmployee}')"
                                    class="btn btn-outline-primary">
                                Choose
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <dl class="row">
        <div class="col-xl-3"></div>
        <dt class="col-xl-2">Full name service:</dt>
        <dd id="nameService" class="col-xl-3"><c:out value="${listContract.nameService}"></c:out></dd>
        <button onclick="displayEditService()" class="col-xl-1 btn btn-outline-primary">
            <i class="far fa-edit"></i>
        </button>
    </dl>
    <div id="displayTableService" class="row">
        <div class="col-lg-12">
            <table id="tableService" class="table table-striped table-bordered" style="width: 100%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Index</th>
                    <th scope="col">Full name</th>
                    <th scope="col">Area used</th>
                    <th scope="col">Rental cost</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${listService}" varStatus="loop">
                    <tr>
                        <td scope="row"><c:out value="${loop.index +1}"/></td>
                        <td><c:out value="${service.name}"/></td>
                        <td><c:out value="${service.areaUsed}"/></td>
                        <td><c:out value="${service.rentalCosts}"/></td>
                        <td>
                            <button onclick="chooseService('${service.idService}','${service.rentalCosts}','${service.name}')"
                                    class="btn btn-outline-primary" id="btnService">
                                Choose
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <dl class="row">
        <div class="col-xl-3"></div>
        <dt class="col-xl-2">Name accompanied service:</dt>
        <dd id="nameAccompaniedService" class="col-xl-3"><c:out value="${listContract.nameAccompaniedService}"></c:out></dd>
        <button onclick="displayEditAccompaniedService()" class="col-xl-1 btn btn-outline-primary">
            <i class="far fa-edit"></i>
        </button>
    </dl>
    <div id="displayTableAccompaniedService" class="row">
        <div class="col-xl-3"></div>
        <div class="col-xl-6">
            <table id="tableAccompaniedService" class="text-center table table-striped table-bordered"
                   style="width: 100%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Index</th>
                    <th scope="col">Name service</th>
                    <th scope="col">Price</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${listAccompaniedService}" varStatus="loop">
                    <tr id="row${service.id}">
                        <td scope="row"><c:out value="${loop.index +1}"/></td>
                        <td><c:out value="${service.name}"/></td>
                        <td><c:out value="${service.price}"/></td>
                        <td>
                            <button name="btn" onclick="chooseAccompaniedService('${service.id}','${service.name}')"
                                    class="btn btn-outline-primary">
                                Choose
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-xl-3"></div>
    </div>
    <div class="row">
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <form action="/contract?actionUser=edit" method="post">
                <input value="${listContractEdit.idContract}" type="hidden" name="idContract" id="idContract">
                <input value="${listContractDetailEdit.idContractDetail}" type="hidden" name="idContractDetail" id="idContractDetail">
                <input type="hidden" name="idAccompaniedService" id="idAccompaniedService">
                <div class="form-group">
                    <label for="amount">Amount</label>
                    <input value="${listContractDetailEdit.amount}" type="text" class="form-control" id="amount"
                           name="amount">
                </div>
                <input type="hidden" id="idEmployee" name="idEmployee">
                <input id="idService" name="idService" type="hidden">
                <input type="hidden" id="idCus" name="idCus">
                <input type="hidden" id="rentalCostsContract" name="rentalCostsContract">
                <div class="form-group">
                    <label for="contractDate">Contract date</label>
                    <input value="${listContractEdit.contractDate}" type="date" class="form-control" id="contractDate"
                           name="contractDate">
                </div>
                <div class="form-group">
                    <label for="contractEndDate">Contract end date</label>
                    <input value="${listContractEdit.contractEndDate}" type="date" class="form-control"
                           id="contractEndDate" name="contractEndDate">
                </div>
                <div class="form-group">
                    <label for="deposits">Deposits</label>
                    <input value="${listContractEdit.deposits}" type="text" class="form-control" id="deposits"
                           name="deposits">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col-lg-3"></div>
    </div>
</div>
<!--Main Layout-->
<div class="container-fluid mt-lg-5" style="background-color: #8e8b8b">
    <div class="row">
        <div class="col-lg-4">
            <h3 class="text-white mt-lg-5">BẢN ĐỒ</h3>
            <iframe class="w-100 h-75"
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3834.50245898014!2d108.24769741416945!3d16.039395344498725!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31420fdbc8cc38ef%3A0x9a6a3e31121225d2!2sFurama%20Resort%20Danang!5e0!3m2!1svi!2s!4v1619427748449!5m2!1svi!2s"
                    style="border:0;" allowfullscreen="" loading="lazy"></iframe>
        </div>

        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <h3 class="text-white mt-lg-5">Liên hệ</h3>
            <p>105 Võ Nguyên Giáp, Ngũ Hành Sơn, Đà Nẵng, Việt Nam</p>
            <p>Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666</p>
            <p>Email: reservation@furamavietnam.com * www.furamavietnam.com</p>
            <img src="img/world-hotel-F-new.png" class="w-100"/>
            <p>GDS-Codes: Amadeus-WWDADFUR, Apollo/Galileo-WW16236, SabreWW32771, Worldspan-WWDADFU</p>
        </div>
    </div>
    <div class="row text-center">
        <div class="col-lg-12">
            <p>© 2018 Furama Resort Danang.</p>
        </div>
    </div>
</div>

<!--js-->
<script src="js/jquery-3.6.0.min.js "></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/mdb.min.js"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCus').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
    $(document).ready(function () {
        $('#tableService').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script src="js/displayFormEditContract.js"></script>
<!--js-->
</body>
</html>