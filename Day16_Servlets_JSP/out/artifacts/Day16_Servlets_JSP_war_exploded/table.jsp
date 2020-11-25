<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="jdk.nashorn.internal.scripts.JD" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head method="GET">
    <title>Title</title>
</head>
<body>
<%
    List<User> users = (List<User>) request.getAttribute("users");


%>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
    </tr>

    <c:forEach items="${users}" var="u" >
        <tr>
            <td>${u.getName()}</td>
            <td>${u.getSurname()}</td>
            <td>${u.getAge()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
