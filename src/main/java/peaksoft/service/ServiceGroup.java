package peaksoft.service;

import peaksoft.model.Group;

import java.util.List;

public interface ServiceGroup {

    Group saveGroup(Group group);

    List<Group> getAllGroups();

    Group getByIdGroup(Long id);

    void updateGroup(Group group, Long id);

    void deleteGroup(Long id);
}
