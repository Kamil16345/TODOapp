package com.java.todoApp.model;

import java.io.Serializable;

public class User implements Serializable {
    private final static long UserID = 1L;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstname){
        this.firstName=firstname;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login=login;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
