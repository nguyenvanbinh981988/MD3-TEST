<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<center>
    <h1>Staff Management</h1>
    <h2>
        <a href="/Department?action=department">Show List Department</a>
        <br>
        <br>
        <a href="/Staff?action=create">Add New Staff</a>
        <br>
        <br>
        <a href="/Staff?action=find">find Staff by Name</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Staffs</h2></caption>
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
        <c:forEach var="staff" items="${staffs}">
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