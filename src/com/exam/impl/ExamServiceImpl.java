package com.exam.impl;

import com.exam.entity.ExamRecord;
import com.exam.entity.Question;
import com.exam.entity.Student;
import com.exam.exception.BusinessException;
import com.exam.service.ExamService;
import com.exam.service.QuestionService;
import com.exam.service.StudentService;
import com.exam.util.DateUtil;
import com.exam.util.FileUtil;

import java.util.*;

public class ExamServiceImpl implements ExamService {
    private final QuestionService questionService;
    private final StudentService studentService;
    private List<ExamRecord> recordList = new ArrayList<>();

    public ExamServiceImpl(QuestionService questionService, StudentService studentService) {
        this.questionService = questionService;
        this.studentService = studentService;
        this.recordList = FileUtil.loadRecords(); // 从文件加载历史记录
    }

    @Override
    public void startExam(Student student) {
        if(student == null) throw new BusinessException("学生不能为空");

        Scanner sc = new Scanner(System.in);
        int questionCount = 0;
        // 输入校验：获取合法的题目数量
        while (true) {
            System.out.print("请输入本次考试的题目数量（1-" + questionService.list().size() + "）：");
            try {
                questionCount = Integer.parseInt(sc.next());
                if (questionCount > 0 && questionCount <= questionService.list().size()) {
                    break;
                } else {
                    System.out.println("输入的数量不合法，请重新输入！");
                }
            } catch (NumberFormatException e) {
                System.out.println("输入不合法，请输入数字！");
            }
        }

        // 随机抽题
        List<Question> questions = ((QuestionServiceImpl) questionService).getRandomQuestions(questionCount);
        int score = 0;

        System.out.println("考生：" + student.getName() + " 班级：" + student.getClassName());
        System.out.println("开始考试，共" + questions.size() + "题");

        for(Question q : questions) {
            System.out.println("\n第" + q.getId() + "题：" + q.getContent());
            System.out.println("A."+q.getOptionA()+" B."+q.getOptionB()+" C."+q.getOptionC()+" D."+q.getOptionD());

            String ans;
            // 输入校验：只接受A/B/C/D
            while (true) {
                System.out.print("请输入答案(A/B/C/D)：");
                ans = sc.next().toUpperCase();
                if ("ABCD".contains(ans)) {
                    break;
                }
                System.out.println("输入无效！请输入A、B、C、D中的一个。");
            }

            if(q.getAnswer().equals(ans)) {
                score += q.getScore();
                System.out.println("回答正确！+"+q.getScore()+"分");
            } else {
                System.out.println("回答错误！正确答案是：" + q.getAnswer());
            }
        }

        // 生成并保存考试记录
        ExamRecord record = new ExamRecord(
                recordList.size() + 1,
                student,
                score,
                DateUtil.getNow()
        );
        recordList.add(record);
        FileUtil.saveRecords(recordList); // 持久化到文件

        System.out.println("======================");
        System.out.println("考试完成");
        System.out.println("姓名：" + record.getStudent().getName());
        System.out.println("得分：" + record.getTotalScore());
        System.out.println("时间：" + record.getExamTime());
        System.out.println("======================");
    }

    // 新增：查询该学生的所有考试记录
    public List<ExamRecord> getRecordsByStudent(Student student) {
        List<ExamRecord> result = new ArrayList<>();
        for (ExamRecord r : recordList) {
            if (r.getStudent().getId().equals(student.getId())) {
                result.add(r);
            }
        }
        return result;
    }
}