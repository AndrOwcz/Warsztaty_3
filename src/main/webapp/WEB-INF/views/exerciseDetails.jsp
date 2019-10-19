<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"%>

<html>
<head>
</head>
<body>

<h2>Exercise</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
    </tr>

        <tr>
            <td><c:out value="${exercise.id}"></c:out></td>
            <td><c:out value="${exercise.title}"></c:out></td>
            <td><c:out value="${exercise.description}"></c:out></td>
        </tr>

</table>

</body>
</html>

<%@ include file="/WEB-INF/views/footer.jsp"%>

