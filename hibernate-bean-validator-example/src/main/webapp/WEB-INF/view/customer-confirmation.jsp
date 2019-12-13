<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>Customer registration form</title>
</head>
<body>
    Customer confirmed: ${customer.firstName} ${customer.lastName}
    <br>
    Free passes: ${customer.freePasses}
    <br>
    Zip code: ${customer.zipCode}
    <br>
    Country: ${customer.country}
    <br>

    <br><br>
    <a href="/">Exit</a>
</body>
</html>