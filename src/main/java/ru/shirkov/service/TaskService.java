package ru.shirkov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shirkov.entity.Task;
import ru.shirkov.repositore.Repo;
import ru.shirkov.repositore.TaskRepo;

@Service
public class TaskService {
    private Repo<Task> taskRepo;
    @Autowired
    public TaskService(Repo<Task> taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task get(Integer id) {
        return taskRepo.getById(id);
    }


}
