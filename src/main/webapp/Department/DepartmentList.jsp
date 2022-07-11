<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Department Management Application</title>
</head>
<body>
<center>
    <h1>Department Management</h1>
    <h2>
        <a href="/Staff?action=users">List All Student</a>
        <br>
        <br>
        <a href="/Department?action=createDepartment">Add New Department</a>
        <br>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Department</h2></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Number</th>
            <th>Adjust</th>

        </tr>
        <c:forEach var="dp" items="${departments}">
            <tr>
                <td><c:out value="${dp.id}"/></td>
                <td><c:out value="${dp.name}"/></td>
                <td><c:out value="${dp.number}"/></td>
                <td>
                    <a href="/Department?action=editDepartment&id=${dp.id}">Edit</a>
                    <a href="/Department?action=deleteDepartment&id=${dp.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

