package peaksoft.service;

import peaksoft.model.Student;

import java.util.List;

public interface ServiceStudent {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getByIdStudent(Long id);

    void updateStudent(Student student, Long id);

    void deleteStudent(Long id);
}
