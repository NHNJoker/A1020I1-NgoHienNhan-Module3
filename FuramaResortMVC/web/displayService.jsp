<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama resort</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
          integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
</head>
<body>
<!-- Navbar -->
<nav id="bg-nav" class="navbar navbar-expand-lg navbar-light bg-light">
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
                        <li><a class="dropdown-item" href="/customer?actionUser=displayCustomer">Display customer</a>
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
            <a class="nav-link" href="/login?actionUser=logOut" data-mdb-toggle="tooltip" data-bs-placement="bottom" title="Log out ${sessionScope.account.userName}">
                Log out
            </a>
        </div>
    </div>
    <!-- Container wrapper -->
</nav>
<!--Main nav-->
<!--Main Layout-->
<div class="container-fluid">
    <div class="row m-3">
        <div class="col-lg-12 text-center">
            <h3>All services</h3>
        </div>
    </div>
    <div class="row m-3">
        <div class="text-primary col-lg-12 text-center">
            <h5>${msg}</h5>
        </div>
    </div>
    <div class="row m-3">
        <div class="col-xl-9"></div>
        <div class="col-xl-3">
            <form class="input-group" action="/service?actionUser=search" method="post">
                <div class="form-outline">
                    <input name="search" type="search" class="form-control rounded" placeholder="Search"
                           aria-label="Search"
                           aria-describedby="search-addon"/>
                </div>
                <button type="submit" class="btn btn-outline-primary">
                    <i class="fas fa-search"></i>
                </button>
            </form>
        </div>
    </div>
    <div class="row">
        <c:if test="${(sizeTableSearch > 0) || (sizeTableDisplayAll > 0)}">
            <c:forEach var="service" items="${listService}" varStatus="loop">
                <div class="col-xl-4">
                    <div class="card" style="width: 18rem;">
                        <img src="${service.linkImg}" class="card-img-top" alt="none">
                        <div class="card-body">
                            <h5 class="card-title"><c:out value="${service.name}"/></h5>
                            <p class="card-text">Area used: <c:out value="${service.areaUsed}"/></p>
                            <p class="card-text">Rental cost: <c:out value="${service.rentalCosts}"/></p>
                            <a href="/service?actionUser=displayServiceDetail&id=${service.idService}"
                               class="btn btn-primary">Detail</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${sizeTableSearch == 0}">
            <h3 class="text-center text-black">Not found</h3>
        </c:if>
    </div>
<c:if test="${(sizeTableSearch > 0) || (sizeTableDisplayAll > 0)}">
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item">
                <c:if test="${msgPagination == 'search'}">
                    <a class="page-link" href="/service?actionUser=search&index=${index -1}&search=${search}" tabindex="-1"
                       aria-disabled="true">Previous</a>
                </c:if>
                <c:if test="${msgPagination == 'displayAll'}">
                    <a class="page-link" href="/service?actionUser=displayService&index=${index -1}&search=${search}" tabindex="-1"
                       aria-disabled="true">Previous</a>
                </c:if>
            </li>
            <c:forEach begin="1" end="${endPage}" var="i">
                <li ${index == i ? ' class="page-item active"' : ''} class="page-item">
                <c:if test="${msgPagination == 'search'}">
                    <a class="page-link" href="/service?actionUser=search&index=${i}&search=${search}">${i}</a></li>
                </c:if>
                <c:if test="${msgPagination == 'displayAll'}">
                    <a class="page-link" href="/service?actionUser=displayService&index=${i}&search=${search}">${i}</a></li>
                </c:if>
            </c:forEach>
            <li class="page-item">
                <c:if test="${msgPagination == 'search'}">
                    <a class="page-link" href="/service?actionUser=search&index=${index +1}&search=${search}">Next</a>
                </c:if>
                <c:if test="${msgPagination == 'displayAll'}">
                    <a class="page-link" href="/service?actionUser=displayService&index=${index +1}&search=${search}">Next</a>
                </c:if>
            </li>
        </ul>
    </nav>
</c:if>
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

<!--js-->
</body>
</html>
