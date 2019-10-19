<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"%>

<html>
<head>
</head>
<body>

<h2>User details ${user.username}</h2>

<table>
    <tr>
        <th>Id</th>
        <th>User group id</th>
        <th>Username</th>
        <th>Email</th>
<%--        <th>Password</th>--%>
    </tr>
    <tr>
        <td><c:out value="${user.id}"></c:out> </td>
        <td><c:out value="${user.user_group_id}"></c:out> </td>
        <td><c:out value="${user.username}"></c:out> </td>
        <td><c:out value="${user.email}"></c:out> </td>
<%--        <td><c:out value="${user.password}"></c:out> </td>--%>
    </tr>
</table>
<h3>User solutions</h3>
<table>
    <tr>
        <th>Id</th>
        <th>Exercise Id</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${userSolutions}" var="solution">
        <tr>
            <td>${solution.id}</td>
            <td>${solution.exercise_id}</td>
            <td>${solution.created}</td>
            <td>${solution.updated}</td>
            <td>${solution.description}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

<%@ include file="/WEB-INF/views/footer.jsp"%>