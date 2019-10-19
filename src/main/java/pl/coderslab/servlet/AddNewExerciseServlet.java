package pl.coderslab.servlet;

import pl.coderslab.dto.Exercise;
import pl.coderslab.service.ExercisesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewExercise", urlPatterns = "/addNewExercise")
public class AddNewExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        ExercisesService exercisesService = new ExercisesService();
        exercisesService.create(new Exercise(title, description));
        response.sendRedirect("/exercises");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/views/newExercise.jsp").forward(request, response);
    }
}
