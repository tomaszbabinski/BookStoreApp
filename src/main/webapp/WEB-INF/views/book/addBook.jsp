<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Form</title>
</head>
<body>
<form:form method="post" modelAttribute="book" action="addBook">
    <label for="title">title <form:input type="text" path="title" id="title"></form:input></label>
    <label for="publisher">Publisher <form:select path="publisher.id" id="publisher">

        <form:options items="${publishers}" itemLabel="name" itemValue="id"></form:options>
            </form:select></label>

    <div><input type="submit"></div>
</form:form>

<a href="../books/showAllBooks">Show all books</a>
</body>
</html>
