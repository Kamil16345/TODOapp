package com.java.todoApp.dao;

import com.java.todoApp.dao.TodoDAO;
import com.java.todoApp.model.TODO;
import com.java.todoApp.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

        }
    }

    @Override
    public TODO selectTODO(long todoId) {
        return null;
    }

    @Override
    public List<TODO> selectAllTodos() {
        return null;
    }

    @Override
    public boolean deleteTodo(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateTodo(int todo) throws SQLException {
        return false;
    }
}
