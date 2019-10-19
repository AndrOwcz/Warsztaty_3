package pl.coderslab.service;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dto.Group;
import pl.coderslab.dto.User;

import java.util.List;

public class UserService {

    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public List<User> findAllByGroupId(int userGroupId) {
        return this.userDao.findAllByGroupId(userGroupId);
    }

    public User read(int userId) {
        return this.userDao.read(userId);
    }

    public List<User> findAll() {
        return this.userDao.findAll();
    }

    public User create(User user) {
        return this.userDao.create(user);
    }

    public void delete(int userId) {
        this.userDao.delete(userId);
    }

    public void update(User user) {
        this.userDao.update(user);
    }

    public void removeGroupFromUser(User user) {
        this.userDao.removeGroup(user);
    }

    public void assignGroupToUser(Group group, User user) {
        this.userDao.assignGroup(user, group);
    }

    public List<User> findAllUnassigned() {
        return this.userDao.findAllUngrouped();
    }

}
