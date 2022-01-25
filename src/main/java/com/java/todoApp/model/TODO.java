package com.java.todoapp.model;

import java.time.LocalDate;

public class TODO {
    private long id;
    private String title;
    private String username;
    private boolean status;
    private LocalDate targetDate;
    private String description;

    protected TODO(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TODO(long id, String title, String username, String description, LocalDate targetDate, boolean isDone){
        super();
        this.id=id;
        this.title=title;
        this.username=username;
        this.description=description;
        this.targetDate=targetDate;
        this.status=isDone;
    }
    public TODO(String title, String username, String description, LocalDate targetDate, boolean isDone) {
        super();
        this.title = title;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.status = isDone;
    }
    @Override
    public int hashCode(){
        final int prime=31;
        int result =1;
        result=prime*result+(int)(id^(id>>>32));
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        TODO other=(TODO)obj;
        if(id!=other.id){
            return false;
        }
        return true;
    }
}