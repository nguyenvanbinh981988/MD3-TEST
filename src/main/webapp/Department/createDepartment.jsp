<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add a Department</title>
</head>
<body>
<center>
    <h1>Add a Department</h1>
    <h2>
        <a href="/Staff?action=staff">List All Staff</a>
        <br>
        <br>
        <a href="/Department?action=department">List All Department</a>

    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Department</h2>
            </caption>
            <tr>
                <th>name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Number:</th>
                <td>
                    <input type="text" name="number" id="number" size="45"/>
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

