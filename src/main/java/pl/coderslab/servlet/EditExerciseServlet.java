package pl.coderslab.servlet;

import pl.coderslab.dto.Exercise;
import pl.coderslab.service.ExercisesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "editExercise", urlPatterns = "/editExercise")
public class EditExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("exerciseId"));
        String newTitle = request.getParameter("title");
        String newDescription = request.getParameter("description");
        ExercisesService exercisesService = new ExercisesService();
        Exercise exerciseToEdit = exercisesService.read(id);
        exerciseToEdit.setTitle(newTitle);
        exerciseToEdit.setDescription(newDescription);
        exercisesService.update(exerciseToEdit);
        response.sendRedirect("/exercises");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ExercisesService exercisesService = new ExercisesService();
        Exercise exercise = exercisesService.read(id);
        request.setAttribute("exercise", exercise);

        getServletContext().getRequestDispatcher("/WEB-INF/views/editExercise.jsp").forward(request, response);
    }
}
