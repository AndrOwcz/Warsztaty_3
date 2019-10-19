package pl.coderslab.servlet;

import pl.coderslab.dto.User;
import pl.coderslab.service.ExercisesService;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUser", urlPatterns = "/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        int id = Integer.parseInt(request.getParameter("userId"));
        String confirmation = request.getParameter("conf");
        if ("yes".equals(confirmation)) {
            userService.delete(id);
        }
        response.sendRedirect("/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserService();
        User user = userService.read(id);
        System.out.println(user.toString());
        request.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/WEB-INF/views/deleteUser.jsp").forward(request, response);
    }
}
