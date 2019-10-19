<%@ include file="/WEB-INF/views/header.jsp" %>


<section class="padding-small details bg-light">
    <div class="container">
        <div class="row">
            <div class="width-medium float-right">
                <a href="/addNewExercise" class="btn btn-warning rounded-0 text-light m-1 float-right ">Add new exercise</a>
            </div>
            <div class="col text-center">


                <h2>Exercises</h2>

                <table>
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${exercises}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.title}</td>
                            <td>${item.description}</td>
                            <td><a href="/exerciseDetails?exerciseId=${item.id}"
                                   class="btn btn-success rounded-0 text-light m-1">Exercise Details</a>
                                <a href="/editExercise?id=${item.id}" class="btn btn-info rounded-0 text-light m-1">Edit</a><a href="/deleteExercise?id=${item.id}" class="btn btn-danger rounded-0 text-light m-1">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
                </body>
            </div>

        </div>
    </div>
</section>

<%@ include file="/WEB-INF/views/footer.jsp" %>

