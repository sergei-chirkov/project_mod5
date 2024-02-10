package ru.shirkov.repositore;

import org.springframework.stereotype.Repository;

@Repository

public class TaskRepo {


//    private final ConnectionPool pool;
//
//    public TaskRepo(ConnectionPool pool){
//        this.pool = pool;
//    }
//
//
//    public Task getById(Long id)  {
//        try(Connection connection = pool.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, description, status \n" +
//                    "//            FROM task \n" +
//                    "//            WHERE id =?");
//            preparedStatement.setLong(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet.next()){
//                Task task = new Task();
//                task.setId(resultSet.getLong("id"));
//                task.setStatus(Status.valueOf(resultSet.getString("status")));
//                task.setDescription(resultSet.getString("description"));
//                return task;
//            }
//            else{
//                throw new RuntimeException("incorrect id");
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
