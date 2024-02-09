package ru.shirkov.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shirkov.dao.TaskDAO;
import ru.shirkov.entity.Status;
import ru.shirkov.entity.Task;

import java.sql.SQLException;
import java.util.List;

@Service
public class TaskService {
    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getALL (int offset, int limit)  {
        return taskDAO.getAll(offset,limit);
    }

    public int getAllCount()  {
        try {
            return taskDAO.getAllCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Task edit(int id, String description, Status status)  {
        Task task = null;
        try {
            task = taskDAO.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(task == null){
            throw new RuntimeException("Not found");
        }
        task.setDescription(description);
        task.setStatus(status);
        try {
            taskDAO.edit(task);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }


    public Task create(String description, Status status)  {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        try {
            taskDAO.edit(task);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }

    @Transactional
    public void delete(int id)  {
        Task task = null;
        try {
            task = taskDAO.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(task == null){
            throw new RuntimeException("Not found");
        }
        taskDAO.delete(task);
    }
}
