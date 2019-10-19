package pl.coderslab.servlet;

import pl.coderslab.dto.Group;
import pl.coderslab.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserGroupServlet", urlPatterns = "/userGroups")
public class UserGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupName = request.getParameter("groupName");

        GroupService groupService = new GroupService();

        Group group = new Group(groupName);

        groupService.create(group);

        response.sendRedirect(request.getContextPath() + "/userGroups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService groupService = new GroupService();

        List<Group> groups = groupService.findAll();

        request.setAttribute("groups", groups);

        getServletContext().getRequestDispatcher("/WEB-INF/views/userGroups.jsp").forward(request, response);

    }
}
