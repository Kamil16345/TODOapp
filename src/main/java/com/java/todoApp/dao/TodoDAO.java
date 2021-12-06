package com.example.todoapp.dao;

import com.example.todoapp.model.TODO;

import java.sql.SQLException;
import java.util.List;

public interface TodoDAO {
    void insertTODO(TODO todo)throws SQLException;
    TODO selectTODO(long todoId);

    List<TODO> selectAllTodos();
    boolean deleteTodo(int id) throws SQLException;
    boolean updateTodo(TODO todo) throws SQLException;
}
