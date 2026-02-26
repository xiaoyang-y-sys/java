package com.exam.service;

import com.exam.entity.Student;
import java.util.List;

public interface StudentService {
    void add(Student student);
    Student getById(Integer id);
    List<Student> list();
}
