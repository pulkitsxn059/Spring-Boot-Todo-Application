package com.example.springbootfirstapplication.model;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class Todo {
    private int id;
    private String name;

    @Size(min = 10, message = "Please Enter 10 Characters..")
    private String desc;
    private Date desiredDate;
    private boolean isCompleted;

    public int getId() {
        return id;
    }

    public Todo()
    {

    }

    public Todo(int id, String name, String desc, Date desiredDate, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.desiredDate = desiredDate;
        this.isCompleted = isCompleted;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDesiredDate(Date desiredDate) {
        this.desiredDate = desiredDate;
    }

    public String getDesc() {
        return desc;
    }

    public Date getDesiredDate() {
        return desiredDate;
    }

    public boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, desiredDate, isCompleted);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", desiredDate=" + desiredDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
