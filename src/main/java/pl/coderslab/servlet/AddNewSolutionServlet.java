package pl.coderslab.servlet;

import pl.coderslab.dto.Exercise;
import pl.coderslab.dto.Solution;
import pl.coderslab.dto.User;
import pl.coderslab.service.ExercisesService;
import pl.coderslab.service.SolutionService;
import pl.coderslab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "AddNewSolution", urlPatterns = "/addNewSolution")
public class AddNewSolutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String description = request.getParameter("description");
        int exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        SolutionService solutionService = new SolutionService();
        Solution solution = new Solution(LocalDateTime.now(), LocalDateTime.now(), description, exerciseId, userId);
        solutionService.createSolution(solution);
        response.sendRedirect("/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExercisesService exercisesService = new ExercisesService();
        UserService userService = new UserService();
        List<Exercise> exercises = exercisesService.findAll();
        List<User> users = userService.findAll();

        request.setAttribute("exercises", exercises);
        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/WEB-INF/views/newSolution.jsp").forward(request, response);
    }
}
