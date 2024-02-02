package ru.shirkov.repositore;

import org.springframework.stereotype.Repository;
import ru.shirkov.config.ConnectionPool;
import ru.shirkov.entity.Status;
import ru.shirkov.entity.Task;

import java.sql.*;


@Repository
public class TaskRepo implements Repo<Task> {
    private final ConnectionPool pool;

//    public static final String GET_BY_ID = """
//            SELECT id, description, status
//            FROM task
//            WHERE id = ?
//            """;

    public TaskRepo(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public Task getById(Integer id) {

        try (Connection connection = pool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,description,status FROM task WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               Task task = new Task();
               task.setId(resultSet.getInt("id"));
               task.setDescription(resultSet.getString("description"));
//               task.setStatus(resultSet.getInt("status")));

               return task;
           }
           else {
               throw new RuntimeException ("incorretion id");
           }



        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            throw new RuntimeException(e);
        }


    }
}
