<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h1>Sign Up</h1>
    <form:form modelAttribute="buyer" action="/sign-up" method="POST">
        <label>Name:</label>
        <form:input path="name" />

        <label>Email:</label>
        <form:input path="email" />

        <label>Password:</label>
        <form:password path="password" />

        <label>Phone Number:</label>
        <form:input path="phoneNumber" />

        <input type="submit" value="Sign Up"/>
    </form:form>
</body>
</html>
