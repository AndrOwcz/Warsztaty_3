<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<html>
<head>
</head>
<body>

<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4">
        <!-- fix action, method -->
        <!-- add name attribute for all inputs -->
        <form action="/userGroups" method="POST">
            <div class="row border-bottom border-3 p-1 m-1">
                <div class="col">
                    <h4 class="color-header">New Group</h4>
                </div>
                <div class="col d-flex justify-content-end mb-2 noPadding">
                    <button type="submit" class="btn btn-danger rounded-0 text-light m-1">Add new group</button>
                </div>
            </div>

            <div class="schedules-content">
                <div class="form-group row">
                    <label for="groupName" class="col-sm-1 label-size col-form-label">
                        Name
                    </label>
                    <div class="col-sm-4">
                        <input name="groupName" class="form-control" rows="3" id="groupName"
                               placeholder="Name"/>
                    </div>
                </div>

            </div>
        </form>
    </div>
</div>

<h3>User groups</h3>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${groups}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><a href="/usersInGroup?id=${item.id}" class="btn btn-info rounded-0 text-light m-1">Edit</a> <a
                    href="/deleteGroup?id=${item.id}" class="btn btn-danger rounded-0 text-light m-1">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

<%@ include file="/WEB-INF/views/footer.jsp" %>