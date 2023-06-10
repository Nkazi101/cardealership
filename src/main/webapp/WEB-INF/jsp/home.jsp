<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Car Dealership</title>
    </head>
    <body>

        <%@ include file="navbar.jsp" %>
        <c:choose>
            <c:when test="${buyer != null}">
                <h1>Welcome, ${buyer.name}!</h1>
            </c:when>
            <c:otherwise>
                <h1>Welcome, guest!</h1>
            </c:otherwise>
        </c:choose>
<!-- 
        <c:if test="${buyer != null}">
            <a href="/profile/${buyer.id}">Profile</a>
        </c:if > -->
    </body>
</html>

