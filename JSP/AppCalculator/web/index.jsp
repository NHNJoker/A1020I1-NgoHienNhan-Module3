<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <form action="/calculator" method="post" onsubmit="return isNum()">
    <p>
      First operand:
      <label>
        <input type="text" name="firstOperand" id="firstOperand">
      </label>
    </p>
    <p>
      Operator:
      <label>
        <select name="operator" id="">
          <option value="+">Addition</option>
          <option value="-">Subtraction</option>
          <option value="*">Multiplication</option>
          <option value="/">division</option>
        </select>
      </label>
    </p>
    <p>
      Second operand:
      <label>
        <input type="text" name="secondOperand" id="secondOperand">
      </label>
    </p>
    <input type="submit" value="Calculator">
  </form>
  <script src="isNum.js"></script>
  </body>
</html>
