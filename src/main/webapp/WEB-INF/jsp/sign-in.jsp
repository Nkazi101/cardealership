<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
    <h1>Sign In</h1>
    <form:form modelAttribute="buyer" action="/sign-in" method="POST">
        <label>Email:</label>
        <form:input path="email" />

        <label>Password:</label>
        <form:password path="password" />

        <input type="submit" value="Sign In"/>
    </form:form>
</body>
</html>

