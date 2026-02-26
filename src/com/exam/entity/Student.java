package com.exam.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String name;
    private String className;

    public Student() {}
    public Student(Integer id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getClassName() {return className;}
    public void setClassName(String className) {this.className = className;}
}




