package pl.coderslab.servlet;

import pl.coderslab.dto.Solution;
import pl.coderslab.dto.User;
import pl.coderslab.service.SolutionService;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserDetailsServlet", urlPatterns = "/userDetails")
public class UserDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));

        UserService userService = new UserService();
        User user = userService.read(userId);
        SolutionService solutionService = new SolutionService();
        List<Solution> solutions = solutionService.findAllSolutionsByUserId(userId);

        request.setAttribute("userSolutions", solutions);
        request.setAttribute("user", user);


        getServletContext().getRequestDispatcher("/WEB-INF/views/userDetails.jsp").forward(request, response);

    }
}
