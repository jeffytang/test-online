package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScoreService {

    /**
     * 通过 id 查询成绩
     * @param studentId
     * @return
     */
    List<Score> findByStudentId(Integer studentId);

    /**
     *查询学生学科的分数
     * @param ExamCode
     * @return
     */
    List<Score> fondByExamCode(Integer ExamCode);

    /**
     *添加一条成绩
     * @param score
     * @return
     */
    int add(Score score);

}
