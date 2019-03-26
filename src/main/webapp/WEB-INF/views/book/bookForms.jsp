<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/Spring01hibernate/resources/css/style.css">
    <title>Book Forms</title>
</head>
<body>
    <h1>Menu</h1>
    <ul>
        <li><a href="../books/addBook">Add new Book</a></li>
        <li><a href="../books/showAllBooks">Show all books</a></li>
        <li></li>
        <li></li>
    </ul>

    <h2>Book data:</h2>

    <form:form method="post" modelAttribute="book" action="getBook">
        <h2>
            Title:
            <form:input path="title" />
        </h2>
             <form:hidden path="id" />
            <input type="submit" value="Send">
    </form:form>
</body>
</html>
