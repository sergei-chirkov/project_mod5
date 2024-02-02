package ru.shirkov;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shirkov.config.Appconfig;
import ru.shirkov.entity.Task;
import ru.shirkov.service.TaskService;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        TaskService bean = context.getBean(TaskService.class);
        Task task = bean.get(1);
        System.out.println("111" + task);


    }
}
