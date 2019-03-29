<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
    <form:form modelAttribute="author" method="post" action="/author/edit">
        <label for="firstName">FirstName
            <form:input type="text" path="firstName" id="firstName"></form:input>
        </label>

        <label for="lastName">LastName
            <form:input type="text" path="lastName" id="lastName"></form:input>
        </label>

        <form:hidden path="id" value="${author.id}"></form:hidden>
        <div><input type="submit" value="Update"></div>
    </form:form>
</body>
</html>
