<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Edit Department</title>
</head>
<body>
<div align="center">
  <form  method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit Department
        </h2>
        <h2>
        <a href="/Department?action=department">Show List Department</a>
        <br>
        <br>
        </h2>
      </caption>
      <c:if test="${department != null}">
        <input type="hidden" name="id" value="<c:out value='${department.id}' />"/>
      </c:if>
      <tr>
        <th>Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="<c:out value='${department.name}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Number:</th>
        <td>
          <input type="text" name="number" size="45"
                 value="<c:out value='${department.number}' />"
          />
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>

