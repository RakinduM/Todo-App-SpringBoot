package org.example.todoappspringboot.controller;

import org.example.todoappspringboot.model.ToDoModel;
import org.example.todoappspringboot.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService service;

    @GetMapping({"/", "viewToDoList"})
    public String viewAllToDoItems(Model model, @ModelAttribute("message") String message){
        model.addAttribute("list", service.getAllToDoItems());
        model.addAttribute("message", message);
        return "ViewToDoList";
    }

    @GetMapping("updateToDoStatus/{id}")
    public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes){
        if (service.updateStatus(id)){
            redirectAttributes.addFlashAttribute("message", "Status updated successfully");
            return "redirect:/viewToDoList";
        }

        redirectAttributes.addFlashAttribute("message", "Status update failed");
        return "redirect:/viewToDoList";
    }

    @GetMapping("/addToDoItem")
    public String addToDoString(Model model){
        model.addAttribute("todo", new ToDoModel());
        return "AddToDoItem";
    }

    @PostMapping("/saveToDoItem")
    public String saveToDoItem(ToDoModel todo, RedirectAttributes redirectAttributes){
        if (service.saveOrUpdateToDoItem(todo)) {
            redirectAttributes.addFlashAttribute("message", "Save Successful");
            return "redirect:/viewToDoList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failed");
        return "redirect:/addToDoItem";
    }

    @GetMapping("/editToDoItem/{id}")
    public String editToDoItem(@PathVariable Long id, Model model) {
        model.addAttribute("todo", service.getToDoItemById(id));

        return "EditToDoItem";
    }

    @PostMapping("/editSaveToDoItem")
    public String editSaveToDoItem(ToDoModel todo, RedirectAttributes redirectAttributes) {
        if(service.saveOrUpdateToDoItem(todo)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewToDoList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editToDoItem/" + todo.getId();
    }

    @GetMapping("/deleteToDoItem/{id}")
    public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (service.deleteToDoItem(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/viewToDoList";
        }

        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/viewToDoList";
    }

}
