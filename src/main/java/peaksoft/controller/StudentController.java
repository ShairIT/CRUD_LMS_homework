package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Student;
import peaksoft.service.ServiceStudent;
import peaksoft.service.ServiceStudentImpl;

@Controller
@RequestMapping("/student/students")
public class StudentController {

    private final ServiceStudent serviceStudent;

    @Autowired
    public StudentController(ServiceStudent serviceStudent){
        this.serviceStudent = serviceStudent;
    }

    @GetMapping
    public String getStudents(Model model){
        model.addAttribute("students", serviceStudent.getAllStudents());
        return"/student/add-students";
    }

    @GetMapping("/add-stident")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "/student/add-student";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student){
        serviceStudent.saveStudent(student);
        return "redrict: /student/students";
    }

    @GetMapping("/update-student/{id}")
    public String updateStudent(@PathVariable("id") Long id, Model model){
        model.addAttribute("student", serviceStudent.getByIdStudent(id));
        return "/student/update-student";
    }

        @PostMapping("/edit-student/{id}")
        public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student){
        serviceStudent.updateStudent(student, id);
        return "redrict: /student/students";
    }

    public String deleteStudent(@PathVariable("id") Long id){
        serviceStudent.deleteStudent(id);
        return "redrict: /student/students";
    }
}
