<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"%>

<html>
<head>
</head>
<body>

<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4">
        <!-- fix action, method -->
        <!-- add name attribute for all inputs -->
        <form action="/editSolution" method="POST">
            <div class="row border-bottom border-3 p-1 m-1">
                <div class="col d-flex justify-content-end mb-2 noPadding">
                    <button type="submit" class="btn btn-info rounded-0 text-light m-1">Edit</button>
                </div>
            </div>
            <input type="hidden" name="solutionId" value="${solution.id}">
            <div class="schedules-content">
                <div class="form-group row">
                    <label for="descriptionId" class="col-sm-1 label-size col-form-label">
                        <h5>description</h5>
                    </label>
                    <div class="col-sm-4">
                        <input value="${solution.description}" name="description" class="form-control" rows="3" id="descriptionId"
                               placeholder="${solution.description}"/>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="exerciseId" class="col-sm-1 label-size col-form-label">
                    <h5>exerciseId</h5>
                </label>
                <div class="col-sm-4">
                    <select class="form-control" id="exerciseId" name="exerciseId">
                        <c:forEach items="${exercises}" var="exercise">
                            <option>${exercise.id}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    Possible choices:
                    <c:forEach items="${exercises}" var="exercises">
                        <option>${exercises.id} - ${exercises.title}</option>
                    </c:forEach>
                </div>
            </div>
            <div class="form-group row">
                <label for="userId" class="col-sm-1 label-size col-form-label">
                    <h5>userId</h5>
                </label>
                <div class="col-sm-4">
                    <select class="form-control" id="userId" name="userId">
                        <c:forEach items="${users}" var="user">
                            <option>${user.id}</option>
                        </c:forEach>
                    </select>
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

<%@ include file="/WEB-INF/views/footer.jsp"%>