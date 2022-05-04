package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Teacher;
import peaksoft.service.ServiceTeacher;

import java.nio.file.Path;

@Controller
@RequestMapping("/teacher/teachers")
public class TeacherController {

    private final ServiceTeacher serviceTeacher;

    @Autowired
    public TeacherController(ServiceTeacher serviceTeacher){
        this.serviceTeacher = serviceTeacher;
    }

    @GetMapping
    public String getTeachers(Model model){
        model.addAttribute("teachers", serviceTeacher.getAllTeachers());
        return "/teacher/teachers";
    }

    @GetMapping("/add-teacher")
    public String addTeacher(Model model){
        model.addAttribute("teacher", new Teacher());
        return "/teacher/teachers";
    }

    @PostMapping("/save-teacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        serviceTeacher.saveTeacher(Teacher);
        return "redirect:/teacher/teachers";
    }

    @GetMapping("/update-teacher/{id}")
    public String updateTeacher(@PathVariable("id") Long id, Model model){
        model.addAttribute(("teacher") serviceTeacher.getByIdTeacher(id));
        return "/teacher/update-teacher";
    }

    @PostMapping("/edit-teacher/{id}"){
        public String editTeacher(@PathVariable("id") Long id, @ModelAttribute("teacher") Teacher teacher){
            serviceTeacher.updateTeacher(teacher, id);
            return "redirect:/teacher/teachers";
        }

    @GetMapping("delete-teacher/{id}")
       public String deleteTeacher(@PathVariable("id") Long id){
            serviceTeacher.deleteTeacher(id);
            return "redirect:/teacher/teachers";

        }

    }
}
