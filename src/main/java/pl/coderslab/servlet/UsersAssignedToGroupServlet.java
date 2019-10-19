package pl.coderslab.servlet;

import pl.coderslab.dto.User;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersAssignedToGroupServlet", urlPatterns = "/usersInGroup")
public class UsersAssignedToGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userGroupId = Integer.parseInt(request.getParameter("id"));

        UserService userService = new UserService();

        List<User> users = userService.findAllByGroupId(userGroupId);

        request.setAttribute("users", users);
        request.setAttribute("groupId", userGroupId);

        getServletContext().getRequestDispatcher("/WEB-INF/views/usersInGroup.jsp").forward(request, response);

    }
}
