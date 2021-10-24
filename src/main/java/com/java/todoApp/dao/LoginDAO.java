package com.java.todoApp.dao;

import com.java.todoApp.model.LoginBean;
import com.java.todoApp.utils.JDBCUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO{
    public boolean validate(LoginBean loginBean)throws ClassNotFoundException{
        boolean status = false;
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("select * from users where login=? and password=? ")){
            preparedStatement.setString(1, loginBean.getLogin());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        }

        catch(SQLException ex) {
            JDBCUtils.printSQLException(ex);
        }
        return status;
    }
}
