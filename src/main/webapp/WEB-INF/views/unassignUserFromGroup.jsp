<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp"%>

        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form action="/unassignUserFromGroup" method="POST">
                    <input type="hidden"  name="userId" value="${user.id}">
                    <input type="hidden"  name="groupId" value="${group.id}">
                    <div class="mt-4 ml-4 mr-4">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Are you sure to unassign:
                                <p></p>
                            ${user.username} from  ${group.name}?</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" name="conf" value="yes" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">YES</button>
                            </div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" name="conf" value="no" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">NO</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
<%@ include file="/WEB-INF/views/footer.jsp"%>