package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.Score;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QueryScoreService {

    /**
     * 通过 id 查询成绩
     * @param studentId
     * @return
     */
    List<Score> findById(Integer studentId);

    /**
     * 分页查询所有的测验科目
     * @param page
     * @return
     */
    IPage<ExamManager> findAll(Page<ExamManager> page);

    /**
     *查询学生学科的分数
     * @param ExamCode
     * @return
     */
    List<Score> fondByExamCode(Integer ExamCode);

    /**
     * 查询所有的成绩信息帮助分页
     * @return
     */
    /*List<Score> findAll();

    IPage<Score> findById(Page<?> page, Integer studentId);*/
}
