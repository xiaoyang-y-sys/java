package com.exam.impl;

import com.exam.entity.Student;
import com.exam.exception.BusinessException;
import com.exam.service.StudentService;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final List<Student> list = new ArrayList<>();

    @Override
    public void add(Student student) {
        if(student == null) throw new BusinessException("学生不能为空");
        list.add(student);
    }

    @Override
    public Student getById(Integer id) {
        for(Student s : list) if(s.getId().equals(id)) return s;
        return null;
    }

    @Override
    public List<Student> list() {
        return list;
    }
}
