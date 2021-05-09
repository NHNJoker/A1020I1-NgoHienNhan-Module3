<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>product</title>
</head>
<body>
<h2>Search</h2>
<form action="/product?actionUser=search" method="post">
    <input type="text" name="search"/>
    <input type="submit">
</form>
<p style="color: red"><c:out value="${msg}"></c:out></p>
<h3>ID:</h3>
<span>
        <c:out value="${productDetail.id}"/>
    </span>
<h3>Name:</h3>
<span>
        <c:out value="${productDetail.name}"/>
    </span>
<h3>price:</h3>
<span>
        <c:out value="${productDetail.price}"/>
    </span>
<h3>Product Description:</h3>
<span>
        <c:out value="${productDetail.productDescription}"/>
    </span>
<h3>manufacturer:</h3>
<span>
        <c:out value="${productDetail.manufacturer}"/>
    </span>
<a href="/">home</a>
</body>
</html>
