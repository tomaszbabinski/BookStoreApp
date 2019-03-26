<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/Spring01hibernate/resources/css/style.css">
    <title>All Books</title>

</head>
<body>

    <h1>Menu</h1>
    <ul>
        <li><a href="../books/addBook">Add new Book</a></li>
        <li><a href="../books/showAllBooks">Show all books</a></li>
        <li></li>
        <li></li>
    </ul>

    <h2>Books List</h2>
    <table>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Description</th>
            <th>Publisher</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.description}</td>
                <td>${book.getPublisher().getName()}</td>
                <td><a href="getBook/${book.id}" >Edit</a> | <a href="deleteBook/${book.id}"> Delete</a></td>
            </tr>
        </c:forEach>



    </table>



</body>
</html>
