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
        <form action="/addUserInGroup" method="POST">
            <div class="row border-bottom border-3 p-1 m-1">
                <div class="col">
                    <h4 class="color-header">Add new user to group with id ${group.id} and name ${group.name}</h4>
                </div>
                <input type="hidden" name="groupId" value="${group.id}">
                <div class="col d-flex justify-content-end mb-2 noPadding">
                    <button type="submit" class="btn btn-warning rounded-0 text-light m-1">Assign user to group</button>
                </div>
            </div>
            <div class="schedules-content">
                <div class="form-group row">
                    <label for="userId" class="col-sm-1 label-size col-form-label">
                        <h5>username:</h5>
                    </label>
                    <div class="col-sm-4">
                        <select class="form-control" id="userId" name="userId">
                            <c:forEach items="${users}" var="user">
                                <option>${user.id}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div>
                    Possible choices:
                    <c:forEach items="${users}" var="user">
                    <option>${user.id} - ${user.username}</option>
                </c:forEach>
                </div>

            </div>
        </form>
    </div>
</div>

</body>
</html>

<%@ include file="/WEB-INF/views/footer.jsp" %>