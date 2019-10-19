<%@ include file="/WEB-INF/views/header.jsp" %>

<section class="padding-small details bg-light">
    <div class="container">
    <div class="width-medium float-right">
        <a href="/addNewSolution" class="btn btn-warning rounded-0 text-light m-1 float-right ">Add new solution</a>
    </div>
    </div>

    <div class="container">

        <div class="row">
            <div class="text-center">
                <h1>Solutions</h1>
                <body>
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Exercise_id</th>
                        <th>User_Id</th>
                        <th>Created</th>
                        <th>Updated</th>
                        <th>Description</th>
<%--                        <th>Solution Details</th>--%>
                        <th>Exercise Details</th>
                        <th>User Details</th>
                        <th>Edit Solution</th>
                        <th>Delete Solution</th>
                    </tr>
                    <c:forEach items="${solutions}" var="item" varStatus="loop">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.exercise_id}</td>
                            <td>${item.users_id}</td>
                            <td>${item.created}</td>
                            <td>${item.updated}</td>
                            <td>${item.description}</td>
<%--                            <td><a href="/solutionDetails?id=${item.id}"--%>
<%--                                   class="btn btn-info rounded-0 text-light m-1">Solution Details</a></td>--%>
                            <td><a href="/exerciseDetails?exerciseId=${item.exercise_id}"
                                   class="btn btn-success rounded-0 text-light m-1">Details</a></td>
                            <td><a href="/userDetails?userId=${item.users_id}"
                                   class="btn btn-success rounded-0 text-light m-1">Details</a></td>
                            <td><a href="/editSolution?solutionId=${item.id}"
                                   class="btn btn-info rounded-0 text-light m-1">Edit</a></td>
                            <td><a href="/deleteSolution?solutionId=${item.id}"
                                   class="btn btn-danger rounded-0 text-light m-1">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
                </body>
            </div>

        </div>
    </div>
</section>

<%@ include file="/WEB-INF/views/footer.jsp" %>

