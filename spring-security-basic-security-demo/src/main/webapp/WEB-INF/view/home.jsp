<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Spring Security Demo</title>
</head>
<body>
<h2>Welcome to Spring Security Demo</h2>
<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>
<security:authorize access="hasRole('MANAGER')">
<p>
    <a href="${pageContext.request.contextPath}/management">Important Leadership Meeting</a>
    (Management only)
</p>
<hr>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<p>
    <a href="${pageContext.request.contextPath}/admin">Admin tools</a>
    (Admins only)
</p>
<hr>
</security:authorize>
<!-- Logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>