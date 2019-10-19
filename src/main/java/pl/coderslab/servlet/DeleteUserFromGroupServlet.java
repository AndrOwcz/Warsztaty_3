package pl.coderslab.servlet;

import pl.coderslab.dto.Group;
import pl.coderslab.dto.Solution;
import pl.coderslab.dto.User;
import pl.coderslab.service.GroupService;
import pl.coderslab.service.SolutionService;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/unassignUserFromGroup")
public class DeleteUserFromGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        int id = Integer.parseInt(request.getParameter("userId"));
        String confirmation = request.getParameter("conf");
        User user = userService.read(id);
        if ("yes".equals(confirmation)) {
            userService.removeGroupFromUser(user);
        }
        response.sendRedirect("/userGroups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        SolutionService solutionService = new SolutionService();
        List<Solution> solutionList = solutionService.findAllSolutionsByUserId(userId);
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        UserService userService = new UserService();
        GroupService groupService = new GroupService();
        Group group = groupService.read(groupId);
        User user = userService.read(userId);

        request.setAttribute("group", group);
        request.setAttribute("user", user);

        if (solutionList.size() == 0) {
            getServletContext().getRequestDispatcher("/WEB-INF/views/unassignUserFromGroup.jsp").forward(request, response);
        } else {
            response.sendRedirect("/usersInGroup?id=" + groupId);
        }
    }
}
