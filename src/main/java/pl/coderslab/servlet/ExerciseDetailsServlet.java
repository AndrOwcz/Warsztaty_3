package pl.coderslab.servlet;

import pl.coderslab.dto.Exercise;
import pl.coderslab.service.ExercisesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseDetailsServlet", urlPatterns = "/exerciseDetails")
public class ExerciseDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String exerciseIdAsString = request.getParameter("exerciseId");
        int exerciseId = Integer.parseInt(exerciseIdAsString);

        ExercisesService exerciseService = new ExercisesService();

        Exercise exercise = exerciseService.read(exerciseId);

        request.setAttribute("exercise", exercise);

        getServletContext().getRequestDispatcher("/WEB-INF/views/exerciseDetails.jsp").forward(request, response);
    }
}
