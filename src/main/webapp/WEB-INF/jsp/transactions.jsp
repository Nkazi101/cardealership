<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transactions</title>
</head>
<body>
    <h1>All Transactions</h1>
    <table>
        <tr>
            <th>Date</th>
            <th>Buyer</th>
            <th>Car</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${transactions}" var="transaction">
            <tr>
                <td><fmt:formatDate value="${transaction.date}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td>${transaction.buyer.name}</td>
                <td>${transaction.car.manufacturerName}</td>
                <td>${transaction.car.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
