<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Cars</title>

</head>
<body>

<jsp:include page="navbar.jsp" />

<h1>Available Cars</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.id}</td>
            <td>${car.manufacturerName}</td>
            <td>${car.price}</td>
            <td>${car.description}</td>
            <td><a href="/cars/${car.id}" class ="btn">Details</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
