<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All authors</title>
</head>
<body>
    <h2>Authors list</h2>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td><a href="http://localhost:8080/author/edit/${author.id}">Edit</a></td>
                <td><a href="http://localhost:8080/author/confirmDeletingAuthor/${author.id}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
