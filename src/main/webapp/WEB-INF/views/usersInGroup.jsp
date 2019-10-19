<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"%>

<html>
<head>
</head>
<body>
<div class="row">
<div class="width-medium float-right">
            <a href="/addUserInGroup?groupId=${groupId}" class="btn btn-warning rounded-0 text-light m-1 float-right">Assign user to group</a>
</div>
</div>
<h2>Users in group ${groupId}</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>User Details</th>
    </tr>
    <c:forEach items="${users}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td><a href="/userDetails?userId=${item.id}" class="btn btn-info rounded-0 text-light m-1">Show user details</a><a href="/unassignUserFromGroup?userId=${item.id}&groupId=${groupId}" class="btn btn-danger rounded-0 text-light m-1">Unassign user from group</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

<%@ include file="/WEB-INF/views/footer.jsp"%>