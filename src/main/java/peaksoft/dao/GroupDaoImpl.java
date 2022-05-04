package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Group saveGroup(Group group){
        entityManager.persist(group);
        return group;
    }

    @Override
    public List<Group> getAllGroups(){
        return entityManager.createQuery("select g from Group g", Group.class).getResultList();
    }

    @Override
    public Group getByIdGroup(Long id){
        return entityManager.find(Group.class, id);
    }

    @Override
    public void updateGroup(Group group, Long id){
        Group group1 =getByIdGroup(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setStudents(group.getStudents());
        entityManager.merge(group1);
    }

    @Override
    public void deleteGroup(Long id){
        entityManager.remove(getByIdGroup(id));
    }

}
