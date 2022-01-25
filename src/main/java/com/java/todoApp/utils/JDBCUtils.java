package com.java.todoapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.TimeZone;

public class JDBCUtils {
    //private static String URL="jdbc:mysql://localhost:3306/todoapp";
    private static String URL="jdbc:mysql://localhost:3306/todoapp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    //private static String URL="jdbc:mysql://localhost:3306/todoapp?useSSL=false";
    //private static String URL = "jdbc:mysql://localhost:3306/todoapp?serverTimezone=" + TimeZone.getDefault().getID();

    private static String username= "root";
    private static String password = "admin";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
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
