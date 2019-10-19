package pl.coderslab.servlet;

import pl.coderslab.dto.Exercise;
import pl.coderslab.dto.User;
import pl.coderslab.service.ExercisesService;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();

        List<User> users = userService.findAll();

        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/WEB-INF/views/users.jsp").forward(request, response);
    }
}
