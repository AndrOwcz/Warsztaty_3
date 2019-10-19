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
        <form action="/addNewExercise" method="POST">
            <div class="row border-bottom border-3 p-1 m-1">
                <div class="col d-flex justify-content-end mb-2 noPadding">
                    <button type="submit" class="btn btn-warning rounded-0 text-light m-1">Add</button>
                </div>
            </div>
            <div class="schedules-content">
                <div class="form-group row">
                    <label for="titleId" class="col-sm-1 label-size col-form-label">
                        <h6>title</h6>
                    </label>
                    <div class="col-sm-4">
                        <input name="title" class="form-control" rows="3" id="titleId"
                               placeholder="title"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="descriptionId" class="col-sm-1 label-size col-form-label">
                        <h6>description</h6>
                    </label>
                    <div class="col-sm-4">
                        <input name="description" class="form-control" rows="3" id="descriptionId"
                               placeholder="description"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>

<%@ include file="/WEB-INF/views/footer.jsp"%>