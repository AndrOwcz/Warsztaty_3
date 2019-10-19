package pl.coderslab.servlet;

import pl.coderslab.dto.Solution;
import pl.coderslab.service.SolutionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteSolution", urlPatterns = "/deleteSolution")
public class DeleteSolutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SolutionService solutionService = new SolutionService();
        int id = Integer.parseInt(request.getParameter("solutionId"));
        String confirmation = request.getParameter("conf");
        if ("yes".equals(confirmation)) {
            solutionService.deleteSolution(id);
        }
        response.sendRedirect("/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("solutionId"));
        SolutionService solutionService = new SolutionService();
        Solution solution = solutionService.readSolution(id);
        request.setAttribute("solution", solution);

        getServletContext().getRequestDispatcher("/WEB-INF/views/deleteSolution.jsp").forward(request, response);
    }
}
