package ru.shirkov.repositore;

import org.springframework.stereotype.Repository;
import ru.shirkov.entity.Task;
@Repository

public class TaskRepo implements Repo<Task>{
    @Override
    public Task getById(Long id) {
        return null;
    }
}
