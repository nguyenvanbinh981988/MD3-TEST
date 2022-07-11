<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Edit a Staff</title>
</head>
<body>
<center>
  <h1>Edit a Staff</h1>
  <h2>
    <a href="/Staff?action=staff">List All Staff</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit Staff
        </h2>
      </caption>
      <c:if test="${staff != null}">
        <input type="hidden" name="id" value="<c:out value='${staff.id}' />"/>
      </c:if>
      <tr>
        <th>Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="<c:out value='${staff.name}' />"
          />
        </td>
      </tr>

      <tr>
        <th>BirthDay:</th>
        <td>
          <input type="text" name="birthDay" size="45"
                 value="<c:out value='${staff.birthDay}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Address:</th>
        <td>
          <input type="text" name="address" size="45"
                 value="<c:out value='${staff.address}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Phone:</th>
        <td>
          <input type="text" name="phone" size="45"
                 value="<c:out value='${staff.phone}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Email:</th>
        <td>
          <input type="text" name="email" size="45"
                 value="<c:out value='${staff.email}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Department:</th>
        <td>
          <input type="text" name="department" size="15"
                 value="<c:out value='${staff.department.name}'/> "
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
