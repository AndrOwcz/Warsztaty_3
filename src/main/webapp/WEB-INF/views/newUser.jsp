<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"%>

<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4">
        <!-- fix action, method -->
        <!-- add name attribute for all inputs -->
        <form action="/addNewUser" method="POST">
            <div class="row border-bottom border-3 p-1 m-1">
                <div class="col d-flex justify-content-end mb-2 noPadding">
                    <button type="submit" class="btn btn-danger rounded-0 text-light m-1">Add</button>
                </div>
            </div>
            <div class="schedules-content">
                <div class="form-group row">
                    <label for="username" class="col-sm-1 label-size col-form-label">
                        <h5>username</h5>
                    </label>
                    <div class="col-sm-4">
                        <input name="username" class="form-control" rows="3" id="username"
                               placeholder="username"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-sm-1 label-size col-form-label">
                        <h5>email</h5>
                    </label>
                    <div class="col-sm-4">
                        <input name="email" class="form-control" rows="3" id="email"
                               placeholder="email"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-sm-1 label-size col-form-label">
                        <h5>password</h5>
                    </label>
                    <div class="col-sm-4">
                        <input name="password" class="form-control" rows="3" id="password"
                               placeholder="password"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="groupId" class="col-sm-1 label-size col-form-label">
                        <h5>groupId</h5>
                    </label>
                    <div class="col-sm-4">
                        <select class="form-control" id="groupId" name="groupId">
                            <c:forEach items="${groups}" var="group">
                                <option>${group.id}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

            </div>
        </form>
    </div>
</div>

</body>
</html>

<%@ include file="/WEB-INF/views/footer.jsp"%>