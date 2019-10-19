package pl.coderslab.servlet;

import pl.coderslab.dto.Exercise;
import pl.coderslab.dto.Group;
import pl.coderslab.dto.User;
import pl.coderslab.service.ExercisesService;
import pl.coderslab.service.GroupService;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "editUser", urlPatterns = "/editUser")
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("userId"));
        String newUsername = request.getParameter("username");
        String newEmail = request.getParameter("email");
        String newPassword = request.getParameter("password");
        int newGroupId = Integer.parseInt(request.getParameter("groupId"));
        UserService userService = new UserService();
        User user = userService.read(id);
        user.setUsername(newUsername);
        user.setEmail(newEmail);
        user.setPassword(newPassword);
        user.setUser_group_id(newGroupId);
        userService.update(user);
        response.sendRedirect("/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserService();
        User user = userService.read(id);
        request.setAttribute("user", user);
        GroupService groupService = new GroupService();
        List<Group> groups = groupService.findAll();
        request.setAttribute("groups", groups);

        getServletContext().getRequestDispatcher("/WEB-INF/views/editUser.jsp").forward(request, response);
    }
}
