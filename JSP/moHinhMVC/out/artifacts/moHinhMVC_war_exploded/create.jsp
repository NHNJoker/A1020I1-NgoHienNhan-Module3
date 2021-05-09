<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <h2>Add new product</h2>
    <form action="/product?actionUser=create" method="post">
        <h3>
            Name of product:
            <lable>
                <input type="text" name="name">
            </lable>
        </h3>
        <h3>
            Price:
            <lable>
                <input type="text" name="price">
            </lable>
        </h3>
        <h3>
            Product Description:
            <lable>
                <input type="text" name="productDescription">
            </lable>
        </h3>
        <h3>
            Manufacturer:
            <lable>
                <input type="text" name="manufacturer">
            </lable>
        </h3>
        <input type="submit" value="submit">
    </form>
    <a href="/">Home</a>
</body>
</html>
