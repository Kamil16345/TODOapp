package com.java.todoApp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBCUtils {
    private static String URL="jdbc:mysql://localhost:3306/todoapp";
    private static String username= "root";
    private static String password = "admin";

    public static Connection getConnection(){
        Connection connection = null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection(URL, username, password);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException cls){
            cls.printStackTrace();
        }
        return connection;
    }
    public static void printSQLException(SQLException exc){
        for(Throwable e: exc){
            if(e instanceof SQLException){
                System.err.println("SQLState: "+((SQLException)e).getSQLState());
                System.err.println("Error Code: "+((SQLException)e).getErrorCode());
                System.err.println("Message: "+ e.getMessage());
                Throwable t = exc.getCause();
                while(t !=null){
                    System.out.println("Cause: "+ t);
                    t.getCause();
                }

            }
        }
    }
    public static Date getSQLDate(LocalDate date){
        return java.sql.Date.valueOf(date);
    }
    public static LocalDate getUtilDate(Date sqlDate){
        return sqlDate.toLocalDate();
    }
}
