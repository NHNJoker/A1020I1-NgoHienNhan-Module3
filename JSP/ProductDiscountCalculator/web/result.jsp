<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>
        Discount Amount:
        <%=request.getAttribute("discountAmount")%>
    </h2>
    <h2>
        Discount Price:
        <%=request.getAttribute("discountPrice")%>
    </h2>
</body>
</html>
