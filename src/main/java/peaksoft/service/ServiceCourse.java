package peaksoft.service;

import peaksoft.model.Course;

import java.util.List;

public interface ServiceCourse {

    Course saveCourse(Course course);

    List<Course> getAllCourses();

    Course getByIdCourse(Long id);

    void updateCourse(Course course, Long id);

    void deleteCourse(Long id);


}
