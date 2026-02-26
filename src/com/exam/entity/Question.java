package com.exam.entity;

import java.io.Serializable;

public class Question implements Serializable {
    private Integer id;
    private String content;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private Integer score;

    public Question() {}

    public Question(Integer id, String content, String optionA, String optionB,
                    String optionC, String optionD, String answer, Integer score) {
        this.id = id;
        this.content = content;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.score = score;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public String getOptionA() {return optionA;}
    public void setOptionA(String optionA) {this.optionA = optionA;}
    public String getOptionB() {return optionB;}
    public void setOptionB(String optionB) {this.optionB = optionB;}
    public String getOptionC() {return optionC;}
    public void setOptionC(String optionC) {this.optionC = optionC;}
    public String getOptionD() {return optionD;}
    public void setOptionD(String optionD) {this.optionD = optionD;}
    public String getAnswer() {return answer;}
    public void setAnswer(String answer) {this.answer = answer;}
    public Integer getScore() {return score;}
    public void setScore(Integer score) {this.score = score;}
}
