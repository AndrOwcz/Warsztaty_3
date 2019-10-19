<%@ include file="/WEB-INF/views/header.jsp" %>


<section class="padding-small details bg-light">
    <div class="container">
        <div class="row">
            <div class="width-medium float-right">
                <a href="/addNewUser" class="btn btn-warning rounded-0 text-light m-1 float-right ">Add new user</a>
            </div>
            <div class="col text-center">


                <h2>Users</h2>

                <table>
                    <tr>
                        <th>Id</th>
                        <th>User group Id</th>
                        <th>Username</th>
                        <th>email</th>
<%--                        <th>password</th>--%>
                        <th>actions</th>
                    </tr>
                    <c:forEach items="${users}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.user_group_id}</td>
                            <td>${item.username}</td>
                            <td>${item.email}</td>
<%--                            <td>${item.password}</td>--%>
                            <td> <a href="/userDetails?userId=${item.id}"
                                    class="btn btn-success rounded-0 text-light m-1">User Details</a>
                                <a href="/editUser?id=${item.id}" class="btn btn-info rounded-0 text-light m-1">Edit</a>
                                <a href="/deleteUser?id=${item.id}" class="btn btn-danger rounded-0 text-light m-1">Delete</a>
                               </td>
                        </tr>
                    </c:forEach>
                </table>
                </body>
            </div>

        </div>
    </div>
</section>

<%@ include file="/WEB-INF/views/footer.jsp" %>

