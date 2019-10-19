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

@WebServlet(name = "editSolution", urlPatterns = "/editSolution")
public class EditSolutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("solutionId"));
        int exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String newDescription = request.getParameter("description");
        SolutionService solutionService = new SolutionService();
        Solution solutionToEdit = solutionService.readSolution(id);
        solutionToEdit.setDescription(newDescription);
        solutionToEdit.setUpdated(LocalDateTime.now());
        solutionToEdit.setExercise_id(exerciseId);
        solutionToEdit.setUsers_id(userId);
        solutionService.updateSolution(solutionToEdit);
        response.sendRedirect("/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("solutionId"));
        SolutionService solutionService = new SolutionService();
        Solution solution = solutionService.readSolution(id);
        request.setAttribute("solution", solution);

        UserService userService = new UserService();
        ExercisesService exercisesService = new ExercisesService();
        List<Exercise> exercises = exercisesService.findAll();
        List<User> users = userService.findAll();

        request.setAttribute("exercises", exercises);
        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/WEB-INF/views/editSolution.jsp").forward(request, response);
    }
}
