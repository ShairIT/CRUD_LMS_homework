package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("select s from Student s", Student.class).getResultList()  ;
    }

    @Override
    public Student getByIdStudent(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void updateStudent(Student student, Long id) {
        Student student1 =getByIdStudent(id);
        student1.setFirstname(student.getFirstname());
        student1.setLastname(student.getLastname());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        entityManager.merge(student1);
    }

    @Override
    public void deleteStudent(Long id) {
        entityManager.remove(getByIdStudent(id));
    }
}
