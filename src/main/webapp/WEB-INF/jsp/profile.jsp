<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>Profile</h1>
    <c:if test="${buyer != null}">
        <h2>Name: ${buyer.name}</h2>
        <h2>Email: ${buyer.email}</h2>
        <h2>Phone Number: ${buyer.phoneNumber}</h2>
    </c:if>
</body>
</html>

