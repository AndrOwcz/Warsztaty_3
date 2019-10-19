package pl.coderslab.service;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.dto.Group;

import java.util.List;

public class GroupService {
    private final GroupDao groupDao;

    public GroupService() {
        this.groupDao = new GroupDao();
    }

    public List<Group> findAll() {
        return this.groupDao.findAll();
    }

    public Group read(int groupId) {
        return this.groupDao.read(groupId);
    }

    public Group create(Group group) {
        return this.groupDao.create(group);
    }

    public void delete(int groupId) {
        this.groupDao.delete(groupId);
    }

    public void update(Group group) {
        this.groupDao.update(group);
    }

}
