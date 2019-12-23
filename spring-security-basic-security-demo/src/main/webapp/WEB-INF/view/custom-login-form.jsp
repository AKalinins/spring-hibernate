<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Custom Login Page</title>

        <style>
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
        <h3>Custom Login Page</h3>

    <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">

        <!-- Error for failed login -->
        <c:if test="${param.error != null}">
            <i class="error">Invalid credentials</i>
        </c:if>


        <!-- Login form -->
        <p>                                 <!-- Default name Spring uses -->
            User name: <input type="text" name="username"/>
        </p>
        <p>                                 <!-- Default name Spring uses -->
            Password: <input type="password" name="password"/>
        </p>
        <input type="submit" value="Login"/>
    </form:form>

    </body>
</html>