<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 16.03.19
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    <label for="firstName">First Name <form:input type="text" path="firstName"></form:input></label><br>
    <label for="lastName">Last Name <form:input type="text" path="lastName"></form:input></label><br>
    <label for="gender">Gender<br>
    Male <form:radiobutton path="gender" value="M"></form:radiobutton>
    Female <form:radiobutton path="gender" value="F"></form:radiobutton></label><br>
    <label for="country">Country <form:select path="country" items="${countries}" /></label><br>
    <label for="notes">Notes<br> <form:textarea rows="10" cols="50" path="notes"></form:textarea></label><br>
    <label for="mailingList">Mailing List <form:checkbox path="mailingList"></form:checkbox></label><br>
    <label for="programmingSkills">Programming Skills<br> <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"></form:select></label><br>
    <label for="hobbies">Hobbies <br><form:checkboxes path="hobbies" items="${hobbies}"></form:checkboxes></label>

    <div><input type="submit"></div>
</form:form>
</body>
</html>
