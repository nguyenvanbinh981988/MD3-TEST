<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2022
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Find Staff By Name</title>
</head>
<body>
<center>
    <h1>Find Staff By Name</h1>
    <h2>
        <a href="/Staff?action=user">List All Staff</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New User</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
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
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Find</h2></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>BirthDay</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Department</th>
            <th>Adjust</th>
        </tr>
        <c:forEach var="staff" items="${findStaffs}">
            <tr>
                <td><c:out value="${staff.id}"/></td>
                <td><c:out value="${staff.name}"/></td>
                <td><c:out value="${staff.birthDay}"/></td>
                <td><c:out value="${staff.address}"/></td>
                <td><c:out value="${staff.phone}"/></td>
                <td><c:out value="${staff.email}"/></td>
                <td><c:out value="${staff.department.name}"/></td>
                <td>
                    <a href="/Staff?action=edit&id=${staff.id}">Edit</a>
                    <a href="/Staff?action=delete&id=${staff.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

