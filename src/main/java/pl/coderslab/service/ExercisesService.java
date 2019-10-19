package pl.coderslab.service;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dto.Exercise;

import java.util.List;

public class ExercisesService {

    private final ExerciseDao exerciseDao;

    public ExercisesService() {
        this.exerciseDao = new ExerciseDao();
    }

    public List<Exercise> findAll() {
        return this.exerciseDao.findAll();
    }

    public Exercise read(int exerciseId) {
        return this.exerciseDao.read(exerciseId);
    }

    public Exercise create(Exercise exercise) {
        return this.exerciseDao.create(exercise);
    }

    public void update(Exercise exercise) {
        this.exerciseDao.update(exercise);
    }

    public void delete(int exerciseId) {
        this.exerciseDao.delete(exerciseId);
    }
}
