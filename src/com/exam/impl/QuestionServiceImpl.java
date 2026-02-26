package com.exam.impl;

import com.exam.entity.Question;
import com.exam.service.QuestionService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionServiceImpl implements QuestionService {
    private final List<Question> list = new ArrayList<>();

    public QuestionServiceImpl() {
        list.add(new Question(1,"main方法返回值？","void","int","String","public","A",10));
        list.add(new Question(2,"哪个是关键字？","import","test","demo","java","A",10));
        list.add(new Question(3,"int占几个字节？","1","2","4","8","C",10));
        list.add(new Question(4,"哪个是循环？","if","for","break","switch","B",10));
        list.add(new Question(5,"String是基本类型？","是","不是","都对","都错","B",10));
        list.add(new Question(6,"数组下标从几开始？","0","1","-1","任意","A",10));
        list.add(new Question(7,"this代表？","当前对象","父类","类","接口","A",10));
        list.add(new Question(8,"super代表？","当前","父类","本类","接口","B",10));
        list.add(new Question(9,"方法重载要求？","同名不同参","同返回值","同类名","同权限","A",10));
        list.add(new Question(10,"Java是？","编译型","解释型","都是","都不是","C",10));
    }

    @Override
    public List<Question> list() {
        return list;
    }

    // 新增：随机抽取指定数量的题目
    public List<Question> getRandomQuestions(int count) {
        if (count <= 0 || count > list.size()) {
            throw new IllegalArgumentException("题目数量不合法");
        }
        List<Question> copy = new ArrayList<>(list);
        Collections.shuffle(copy); // 打乱顺序
        return copy.subList(0, count);
    }
}