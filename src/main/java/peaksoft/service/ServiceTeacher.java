package peaksoft.service;

import peaksoft.model.Teacher;

import java.util.List;

public interface ServiceTeacher {

    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher getByIdTeacher(Long id);

    void updateTeacher(Teacher teacher, Long id);

    void deleteTeacher(Long id);






}
