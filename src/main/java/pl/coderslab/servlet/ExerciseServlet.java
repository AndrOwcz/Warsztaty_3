package pl.coderslab.servlet;

import pl.coderslab.dto.Exercise;
import pl.coderslab.service.ExercisesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExerciseServlet", urlPatterns = "/exercises")
public class ExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExercisesService exerciseService = new ExercisesService();

        List<Exercise> exercises = exerciseService.findAll();

        request.setAttribute("exercises", exercises);

        getServletContext().getRequestDispatcher("/WEB-INF/views/exercises.jsp").forward(request, response);
    }
}
