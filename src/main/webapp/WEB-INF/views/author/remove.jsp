<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Remove Author</title>
</head>
<body>


<table class="table">
    <thead>
    <tr>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${author.firstName}</td>
        <td>${author.lastName}</td>
    </tr>
    </tbody>
</table>

<br>


<form:form method="post" action="/author/deleteAuthor" class="form-horizontal">
    <p>Do you confirm that above author should be removed?</p>
    <input type="hidden" var="id" name="id" value="${author.id}"/>
    <div><button type="submit">Submit</button></div>
    <div><a href="../list">No</a></div>

</form:form>

</body>
</html>
