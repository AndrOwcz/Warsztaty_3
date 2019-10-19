package pl.coderslab.dao;

import pl.coderslab.dto.Solution;
import pl.coderslab.util.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionDao {

    private static final String CREATE_SOLUTION_QUERY =
            "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES (?,?,?,?,?)";
    private static final String READ_SOLUTION_QUERY =
            "SELECT * FROM solution where id = ?";
    private static final String UPDATE_SOLUTION_QUERY =
            "UPDATE solution SET created = ?, updated = ?, description = ?, exercise_id = ?, users_id = ? where id = ?";
    private static final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solution WHERE id = ?";
    private static final String FIND_ALL_SOLUTIONS_QUERY =
            "SELECT * FROM solution";
    private static final String FIND_ALL_SOLUTIONS_BY_USER_ID_QUERY =
            "SELECT * FROM solution JOIN users ON solution.users_id = users.id WHERE users.id = ?";
    private static final String FIND_ALL_SOLUTIONS_BY_EXERCISE_ID_QUERY =
            "SELECT * FROM solution JOIN exercise ON solution.exercise_id = exercise.id WHERE exercise.id = ?";

    public Solution create(Solution solution) {
        try (Connection conn = DBUtil.getConn()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_SOLUTION_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, solution.getCreated().toString());
            statement.setString(2, solution.getUpdated().toString());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExercise_id());
            statement.setInt(5, solution.getUsers_id());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution read(int solutionId) {
        try (Connection conn = DBUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getObject("created",LocalDateTime.class));
                solution.setUpdated(resultSet.getObject("updated",LocalDateTime.class));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUsers_id(resultSet.getInt("users_id"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Solution solution) {
        try (Connection conn = DBUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setString(1, solution.getCreated().toString());
            statement.setString(2, solution.getUpdated().toString());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getExercise_id());
            statement.setInt(5, solution.getUsers_id());
            statement.setInt(6, solution.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DBUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Solution> findAll() {
        try (Connection conn = DBUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTIONS_QUERY);
            return resultSetSolutions(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Solution> findAllByUserId(int userId) {
        try (Connection conn = DBUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTIONS_BY_USER_ID_QUERY);
            statement.setInt(1, userId);
            return resultSetSolutions(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Solution> findAllExerciseId(int exerciseId) {
        try (Connection conn = DBUtil.getConn()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTIONS_BY_EXERCISE_ID_QUERY);
            statement.setInt(1, exerciseId);
            return resultSetSolutions(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private List<Solution> resultSetSolutions(PreparedStatement statement) {
        try {
            List<Solution> solutions = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getObject("created",LocalDateTime.class));
                solution.setUpdated(resultSet.getObject("updated",LocalDateTime.class));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUsers_id(resultSet.getInt("users_id"));
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}


