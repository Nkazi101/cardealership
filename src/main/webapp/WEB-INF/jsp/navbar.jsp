<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value='/css/navbar.css'/>" rel="stylesheet">

</head>
<body>

<div class="navbar">
  <a href="/">Home</a>
  <a href ="/cars/available">Cars</a>
  <c:if test="${buyer != null}">
    <a href="/profile/${buyer.id}">Profile</a>
</c:if >
  <!-- <a href="/profile">Profile</a> -->
  <a href="/transactions">Transactions</a>
  <a href="/sign-in">Sign-In</a>
  <a href="/sign-up">Sign-Up</a>
</div>


</body>
</html>
