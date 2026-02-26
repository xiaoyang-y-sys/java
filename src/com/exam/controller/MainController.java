package com.exam.controller;

import com.exam.entity.ExamRecord;
import com.exam.entity.Student;
import com.exam.impl.ExamServiceImpl;
import com.exam.impl.QuestionServiceImpl;
import com.exam.impl.StudentServiceImpl;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private final Scanner sc = new Scanner(System.in);
    private final StudentServiceImpl studentService = new StudentServiceImpl();
    private final QuestionServiceImpl questionService = new QuestionServiceImpl();
    private final ExamServiceImpl examService = new ExamServiceImpl(questionService, studentService);

    public void start() {
        studentService.add(new Student(1001,"小明","Java一班"));
        while(true) {
            System.out.println("\n===== 考试系统 =====");
            System.out.println("1. 进入考试");
            System.out.println("2. 查看我的成绩");
            System.out.println("0. 退出");
            System.out.print("请选择：");
            int c = sc.nextInt();
            if(c == 1) {
                examService.startExam(studentService.getById(1001));
            } else if(c == 2) {
                viewScores(studentService.getById(1001));
            } else if(c == 0) {
                System.out.println("退出成功");
                return;
            }
        }
    }

    // 新增：查看成绩
    private void viewScores(Student student) {
        List<ExamRecord> records = examService.getRecordsByStudent(student);
        if (records.isEmpty()) {
            System.out.println("暂无考试记录。");
            return;
        }
        System.out.println("\n===== 历史成绩 =====");
        for (ExamRecord r : records) {
            System.out.println(r.getExamTime() + " | 得分: " + r.getTotalScore() + "分");
        }
    }
}