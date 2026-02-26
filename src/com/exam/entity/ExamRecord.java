package com.exam.entity;

import java.io.Serializable;

public class ExamRecord implements java.io.Serializable {
    private Integer recordId;
    private Student student;
    private Integer totalScore;
    private String examTime;

    public ExamRecord() {}

    public ExamRecord(Integer recordId, Student student, Integer totalScore, String examTime) {
        this.recordId = recordId;
        this.student = student;
        this.totalScore = totalScore;
        this.examTime = examTime;
    }

    public Integer getRecordId() {return recordId;}
    public void setRecordId(Integer recordId) {this.recordId = recordId;}
    public Student getStudent() {return student;}
    public void setStudent(Student student) {this.student = student;}
    public Integer getTotalScore() {return totalScore;}
    public void setTotalScore(Integer totalScore) {this.totalScore = totalScore;}
    public String getExamTime() {return examTime;}
    public void setExamTime(String examTime) {this.examTime = examTime;}
}
