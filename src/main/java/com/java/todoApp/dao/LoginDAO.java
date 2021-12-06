package com.example.todoapp.dao;

import com.example.todoapp.model.LoginBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO{
    public boolean validate(LoginBean loginBean)throws ClassNotFoundException{
        boolean status = false;
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = com.example.todoapp.utils.JDBCUtils.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("select * from users where username=? and password=? ")){
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        }

        catch(SQLException ex) {
            com.example.todoapp.utils.JDBCUtils.printSQLException(ex);
        }
           return status;
    }
}
