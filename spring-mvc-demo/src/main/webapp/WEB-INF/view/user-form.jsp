<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
    <head>
        <title>User registration form</title>
    </head>
    <body>
        <form:form action="processUserForm" modelAttribute="user">
            First name: <form:input path="firstName" />
            <br>
            Last name:  <form:input path="lastName" />
            <br>
            <form:select path="sex">
                <form:options items="${sexOptions}" />
            </form:select>
            <br>
            <form:select path="country">
                <form:options items="${user.countries}"/>
                <form:option value="Lithuania" label="Lithuania"/>
                <form:option value="England" label="England"/>
                <form:option value="Germany" label="Germany"/>
            </form:select>
            <br>
            Programming Language:
            <form:radiobutton path="language" value="Java" /> Java
            <form:radiobutton path="language" value="C++" /> C++
            <form:radiobutton path="language" value="C#" /> C#
            <form:radiobutton path="language" value="JavaScript" /> JavaScript
            <br>
            Operating System:
            <form:checkbox path="operatingSystems" value="MS Windows" /> MS Windows
            <form:checkbox path="operatingSystems" value="Linux" /> Linux
            <form:checkbox path="operatingSystems" value="Mac OS" /> Mac OS
            <br><br>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>