package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.service.ServiceCourse;

@Controller
@RequestMapping("/course/courses")
public class CourseController {

    private final ServiceCourse serviceCourse;

    public CourseController(ServiceCourse serviceCourse) {
        this.serviceCourse = serviceCourse;
    }

    @GetMapping
    public String getCourses(Model model){
        model.addAttribute("courses", serviceCourse.getAllCourses());
        return "/course/courses";
    }

    @GetMapping("/add-course")
    public String addCourse(Model model){
        model.addAttribute("course", new Course());
        return "/course/add-course";
    }

    @PostMapping("/save-course")
    public String saveCourse(@ModelAttribute("course") Course course){
        serviceCourse.saveCourse(course);
        return "redirect:/course/courses";
    }

    @GetMapping("/update-course/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model){
        model.addAttribute("course", serviceCourse.getByIdCourse(id));
        return "/course/update-course";
    }

    @PostMapping("/edit-course/{id}")
    public String editCourse(@PathVariable("id") Long id, @ModelAttribute("course") Course course){
        serviceCourse.updateCourse(course, id);
        return "redirect:/course/courses";
    }

    @GetMapping("/delete-course/{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        serviceCourse.deleteCourse(id);
        return "redirect:/course/courses";
    }


}
