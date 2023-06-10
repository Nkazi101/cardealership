<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Car Details</title>
</head>
<body>
    <h1>${car.manufacturerName}</h1>
    <p>Model: ${car.makeModel}</p>
    <p>Year: ${car.year}</p>
    <p>Price: ${car.price}</p>
    <p>Description: ${car.description}</p>
    <img src="${car.pictureUrl}" alt="Car image">
    <p><a href="/bid/${car.id}">Place a bid</a></p>
</body>
</html>
