package pl.coderslab.servlet;

import pl.coderslab.dto.Exercise;
import pl.coderslab.service.ExercisesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteExercise", urlPatterns = "/deleteExercise")
public class DeleteExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExercisesService exercisesService = new ExercisesService();
        int id = Integer.parseInt(request.getParameter("exerciseId"));
        String confirmation = request.getParameter("conf");
        if ("yes".equals(confirmation)) {
            exercisesService.delete(id);
        }
        response.sendRedirect("/exercises");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ExercisesService exercisesService = new ExercisesService();
        Exercise exercise = exercisesService.read(id);
        request.setAttribute("exercise", exercise);

        getServletContext().getRequestDispatcher("/WEB-INF/views/deleteExercise.jsp").forward(request, response);
    }
}
