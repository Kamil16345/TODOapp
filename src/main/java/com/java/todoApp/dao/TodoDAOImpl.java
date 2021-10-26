package com.java.todoApp.dao;

import com.java.todoApp.dao.TodoDAO;
import com.java.todoApp.model.TODO;
import com.java.todoApp.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoDAOImpl implements TodoDAO {
    private static final String INSERT_TASKS_SQL="INSERT INTO tasks (title, username, description, target_date, is_done)"+
            "VLUES"+"(?,?,?,?);";
    private static final String SELECT_TODO_BY_ID = "select id, title, username, description, target_date, is_done from taska where id=?";
    private static final String SELECT_ALL_TODOS = "select * from tasks";
    private static final String DELETE_TODO_BY_ID ="delete from tasks where id=?;";
    private static final String UPDATE_TODO="update tasks set title=? ,username=?,description=?, target_date=?, is_done=? where id=?;";

    public TodoDAOImpl(){}
    @Override
    public void insertTODO(TODO todo) throws SQLException {
        System.out.println(INSERT_TASKS_SQL);

        try(Connection connection = JDBCUtils.getConnection(); PreparedStatement preparedStatement=
                connection.prepareStatement(INSERT_TASKS_SQL)){
            preparedStatement.setString(1,todo.getTitle());
            preparedStatement.setString(2,todo.getLogin());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
            preparedStatement.setBoolean(5, todo.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception){
            JDBCUtils.printSQLException(exception);
        }
    }

    @Override
    public TODO selectTODO(long todoId) {
        TODO todo=null;
        try(Connection connection=JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID);){
            preparedStatement.setLong(1, todoId);

            System.out.println(preparedStatement);
            ResultSet rs=preparedStatement.executeQuery();

            while(rs.next()){
                long id = rs.getLong("id");
                String title=rs.getString("title");
                String username=rs.getString("username");
                String description = rs.getString("description");
                LocalDate targetDate = rs.getDate("target_date").toLocalDate();
                boolean isDone = rs.getBoolean("status");
                todo= new TODO(id, title, username, description, targetDate, isDone);
            }
            }
        catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return todo;
    }

    @Override
    public List<TODO> selectAllTodos() {
        List <TODO> todos = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                long id = rs.getLong("id");
                String username = rs.getString("username");
                String title=rs.getString("title");
                String description = rs.getString("description");
                LocalDate targetDate= rs.getDate("target_date").toLocalDate();
                boolean isDone = rs.getBoolean("status");
                todos.add(new TODO(id, title, username, description, targetDate, isDone));
            }
        }
        catch(SQLException exception){
            JDBCUtils.printSQLException(exception);
        }
        return todos;
    }

    @Override
    public boolean deleteTodo(int id) throws SQLException {
        boolean rowDeleted = false;
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TODO_BY_ID);){
            preparedStatement.setInt(1, id);
            rowDeleted=preparedStatement.executeUpdate()>0;
        }catch(SQLException exception){
            JDBCUtils.printSQLException(exception);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateTodo(TODO todo) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TODO);) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getLogin());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
            preparedStatement.setBoolean(5, todo.getStatus());
            preparedStatement.setLong(6, todo.getId());
            rowUpdated = preparedStatement.executeUpdate()>0;
        }catch (SQLException exception){
            JDBCUtils.printSQLException(exception);
        }
        return rowUpdated;
    }
}
