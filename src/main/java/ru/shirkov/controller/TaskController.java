package ru.shirkov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shirkov.entity.Task;
import ru.shirkov.service.TaskService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping()
    public String tasks(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam (value = "limit", required = false, defaultValue = "10") int limit){

        List<Task> all = taskService.getALL((page - 1) * limit, limit);
        model.addAttribute("tasks", all);

        int allCount = taskService.getAllCount();
        List<Integer> pages = new ArrayList<>();
        int countpage = (int)Math.ceil((double) allCount / limit);
        for (int i = 0; i < countpage; i++){
            pages.add(i + 1);
        }
        model.addAttribute("pages", pages);
        model.addAttribute("limit", limit);
        return "tasks";
    }


    @PostMapping({"/{id}"})
    public String edit(Model model,
                     @PathVariable("id") Integer id,
                     @RequestBody TaskDTO taskDTO){

        if(id == null || id <= 0){
            throw new RuntimeException("Invalid id");
        }

        Task task = taskService.edit(id, taskDTO.getDescription(), taskDTO.getStatus());

        return tasks(model,1,10);
    }

    @PostMapping("/")
    public String add(Model model, @RequestBody TaskDTO taskDTO){
        Task task = taskService.create(taskDTO.getDescription(), taskDTO.getStatus());
        return tasks(model,1,10);
    }

    @DeleteMapping(value = {"/{id}"})
    public String delete (Model model, @PathVariable("id") Integer id){

        if(id == null || id <= 0){
            throw new RuntimeException("Invalid id");
        }
        taskService.delete(id);

        return tasks(model,1,10);
    }

}
