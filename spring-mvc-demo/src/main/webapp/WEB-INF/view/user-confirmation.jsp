<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <title>User registration form</title>
</head>
<body>
    User confirmed: ${user.firstName} ${user.lastName}
    <br>
    Country: ${user.country}
    <br>
    Sex: ${user.sex}
    <br>
    Language: ${user.language}
    <br>
    OS:
    <ul>
        <c:forEach var="temp" items="${user.operatingSystems}">
            <li>${temp}</li>
        </c:forEach>
    </ul>
    <br><br>
    <a href="/">Exit</a>
</body>
</html>