<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Adding Author</title>

</head>
<body>

    <form:form method="post" modelAttribute="author" action="add">
        <label for="firstName"> First Name
        <form:input type="text" path="firstName" id="firstName"></form:input>
        </label>
        <label for="lastName"> Last Name
            <form:input type="text" path="lastName" id="lastName"></form:input>
        </label>
        <label for="email"> Email
            <form:input type="text" path="email" id="email"></form:input>
        </label>
        <div><input type="submit"></div>


    </form:form>

</body>
</html>
