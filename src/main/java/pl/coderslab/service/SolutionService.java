package pl.coderslab.service;

import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dto.Article;
import pl.coderslab.dto.Solution;
import pl.coderslab.exception.ArticleNotFoundException;

import java.util.Collection;
import java.util.List;

public class SolutionService {

    private final SolutionDao solutionDao;

    public SolutionService() {
        this.solutionDao = new SolutionDao();
    }

    public List<Solution> findAllSolutions() {
        return solutionDao.findAll();
    }

    public List<Solution> findAllSolutionsByUserId(int userId) {
        return solutionDao.findAllByUserId(userId);
    }

    public List<Solution> findAllSolutionsByExerciseId(int exerciseId) {
        return solutionDao.findAllExerciseId(exerciseId);
    }

    public Solution createSolution(Solution solution) {
        return solutionDao.create(solution);
    }

    public void deleteSolution(int id) {
        this.solutionDao.delete(id);
    }

    public void updateSolution(Solution solution) {
        this.solutionDao.update(solution);
    }

    public Solution readSolution(int id) {
        return solutionDao.read(id);
    }
}
