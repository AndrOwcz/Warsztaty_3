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

@WebServlet(name = "AddNewUser", urlPatterns = "/addNewUser")
public class AddNewUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String groupIdAsString = request.getParameter("groupId");
        int groupId = Integer.parseInt(groupIdAsString);
        UserService userService = new UserService();
        userService.create(new User(username, email, password, groupId));
        response.sendRedirect("/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupService groupService = new GroupService();
        List<Group> groups = groupService.findAll();
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/WEB-INF/views/newUser.jsp").forward(request, response);
    }
}
