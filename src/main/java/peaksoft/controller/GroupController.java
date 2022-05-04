package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Group;
import peaksoft.service.ServiceGroup;

@Controller
@RequestMapping("/group/groups")
public class GroupController {

    private final ServiceGroup serviceGroup;

    @Autowired
    public GroupController(ServiceGroup serviceGroup){
        this.serviceGroup = serviceGroup;
    }

    @GetMapping
    public String getGroups(Model model){
        model.addAttribute("groups", serviceGroup.getAllGroups());
        return "/group/groups";
    }

    @GetMapping("/add-group")
    public String addGroup(Model model){
        model.addAttribute("group", new Group());
        return "/group/add-group";
    }

    @PostMapping("/save-group")
    public String saveGroup(@ModelAttribute("group") Group group) {
        serviceGroup.saveGroup(group);
        return "redirect:/group/groups";
    }

    @GetMapping("/update-group/{id}")
    public String updateGroup(@PathVariable("id") Long id, Model model) {
        model.addAttribute("group", serviceGroup.getByIdGroup(id));
        return "/group/update-group";
    }

    @PostMapping("/edit-group/{id}")
    public String editGroup(@PathVariable("id") Long id, @ModelAttribute("group") Group group) {
        serviceGroup.updateGroup(group, id);
        return "redirect:/group/groups";
    }

    @GetMapping("/delete-group/{id}")
    public String deleteGroup(@PathVariable("id") Long id) {
        serviceGroup.deleteGroup(id);
        return "redirect:/group/groups";
    }

}
