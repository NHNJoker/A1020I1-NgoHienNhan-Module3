<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ứng dụng Product Discount Calculator</title>
  </head>
  <body>
    <form action="/discount" method="post">
      <p>
        Product Description :
        <label>
          <input type="text" name="productDescription">
        </label>
      </p>
      <p>
        List Price:
        <label>
          <input type="text" name="listPrice">
        </label>
      </p>
      <p>
        Discount Percent:
        <label>
          <input type="text" name="discountPercent">
        </label>
      </p>
      <input type="submit" value="discount">
    </form>
  </body>
</html>
