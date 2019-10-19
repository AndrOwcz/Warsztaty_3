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

@WebServlet(name = "NewUserInGroupServlet", urlPatterns = "/addUserInGroup")
public class NewUserInGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        System.out.println(request.getParameter("groupId"));
        System.out.println(groupId);
        int userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println(request.getParameter("userId"));
        System.out.println(userId);
        UserService userService = new UserService();
        GroupService groupService = new GroupService();
        User user = userService.read(userId);
        Group group = groupService.read(groupId);
        userService.assignGroupToUser(group, user);

        response.sendRedirect(request.getContextPath() + "/usersInGroup?id=" + groupId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int groupId = Integer.parseInt(request.getParameter("groupId"));
        GroupService groupService = new GroupService();
        UserService userService = new UserService();
        Group group = groupService.read(groupId);
        List<User> users = userService.findAllUnassigned();

        request.setAttribute("group", group);
        request.setAttribute("users", users);


        getServletContext().getRequestDispatcher("/WEB-INF/views/addUserInGroup.jsp").forward(request, response);
    }
}
