package ru.shirkov.repositore;

import org.springframework.stereotype.Repository;
import ru.shirkov.entity.Status;
import ru.shirkov.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository

public class TaskRepo implements Repo<Task>{
    private final ConnectionPool pool;

    public static final String GET_BY_ID = "SELECT id, description, status FROM task WHERE id = ?";

    public TaskRepo(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public Task getById(Long id) {
       try(Connection connection = pool.getConnection()){
           PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
           preparedStatement.setLong(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               Task task = new Task();
               task.setId(resultSet.getLong("id"));
               task.setDescription(resultSet.getString("description"));
               task.setStatus(Status.valueOf(resultSet.getString("status")));

               return task;
           }
           else {
               throw new RuntimeException ("incorretion id");
           }


       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }
}
