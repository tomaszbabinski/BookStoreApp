<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/Spring01hibernate/resources/css/style.css">
    <title>Delete Confirmation</title>
</head>
<body>
    <h1>Menu</h1>
        <ul>
            <li><a href="../books/addBook">Add new Book</a></li>
            <li><a href="../books/showAllBooks">Show all books</a></li>
            <li></li>
            <li></li>
        </ul>


    <h1>Are you sure you want to delete this book?</h1>
    <h2>Title: ${book.title}</h2>
    <h2>Description: ${book.description}</h2>

    <h2><a href="../deleteBook/${book.id}" >YES</a> | <a href="../presentBookForm">NO</a></h2>


</body>
</html>
