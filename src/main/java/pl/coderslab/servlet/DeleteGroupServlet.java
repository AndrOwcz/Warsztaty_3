package pl.coderslab.servlet;

import pl.coderslab.dto.Group;
import pl.coderslab.dto.User;
import pl.coderslab.service.GroupService;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteGroupServlet", urlPatterns = "/deleteGroup")
public class DeleteGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupService groupService = new GroupService();
        int id = Integer.parseInt(request.getParameter("groupId"));
        String confirmation = request.getParameter("conf");
        if ("yes".equals(confirmation)) {
            groupService.delete(id);
        }
        response.sendRedirect("/userGroups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int groupId = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserService();
        GroupService groupService = new GroupService();

        List<User> userList = userService.findAllByGroupId(groupId);
        Group group = groupService.read(groupId);
        request.setAttribute("group", group);

        if (userList.size() == 0) {
            getServletContext().getRequestDispatcher("/WEB-INF/views/deleteGroup.jsp").forward(request, response);
        } else {
            response.sendRedirect("/userGroups");
        }

    }
}
