package com.exam.util;

import com.exam.entity.ExamRecord;
import com.exam.exception.BusinessException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String RECORD_FILE = "exam_records.dat";

    // 保存考试记录到文件
    public static void saveRecords(List<ExamRecord> records) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RECORD_FILE))) {
            oos.writeObject(records);
        } catch (IOException e) {
            throw new BusinessException("保存考试记录失败: " + e.getMessage());
        }
    }

    // 从文件加载考试记录
    @SuppressWarnings("unchecked")
    public static List<ExamRecord> loadRecords() {
        File file = new File(RECORD_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<ExamRecord>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}