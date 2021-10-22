package com.java.todoApp.dao;

import com.java.todoApp.utils.JDBCUtils;
import com.java.todoApp.dao.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    public int registerEmployee(User employee) throws ClassNotFoundException{
        String INSERT_USERS_SQL="INSERT INTO users"+
                "(login, password, first_name, last_name) VALUES" +
                "(?, ?, ?, ?);";
        int result =0;
        try(Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());

            System.out.println(preparedStatement);
            result=preparedStatement.executeUpdate();
        } catch(SQLException e){
            JDBCUtils.printSQLException(e);
        }
        return result;
    }
}
