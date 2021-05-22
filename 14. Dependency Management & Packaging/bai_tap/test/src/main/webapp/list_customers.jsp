<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List customers</title>
</head>
<body>
    <h2>List customers</h2>
    <table border="1">
        <tr>
            <th>Ten</th>
            <th>Ngay sinh</th>
            <th>Dia chi</th>
            <th>Anh</th>
        </tr>
        <c:forEach var="customer" items="${customer}">
            <tr>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.dateOfBirth}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td><img src="${customer.linkImg}" alt="" width="180px" height="180px"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
