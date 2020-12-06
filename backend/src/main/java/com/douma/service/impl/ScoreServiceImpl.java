package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.Score;
import com.douma.mapper.ScoreMapper;
import com.douma.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * 通过 id 查询成绩
     * @param studentId
     * @return
     */
    @Override
    public List<Score> findByStudentId(Integer studentId) {
        return scoreMapper.selectByStudentId(studentId);
    }


    /**
     *查询学生学科的分数
     * @param ExamCode
     * @return
     */
    @Override
    public List<Score> fondByExamCode(Integer ExamCode) {
        return scoreMapper.selectByExamCode(ExamCode);
    }

}
