package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.Score;
import com.douma.mapper.QueryScoreMapper;
import com.douma.service.QueryScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryScoreServiceImpl implements QueryScoreService {
    @Autowired
    private QueryScoreMapper scoreMapper;

    /**
     * 通过 id 查询成绩
     * @param studentId
     * @return
     */
    @Override
    public List<Score> findById(Integer studentId) {
        return scoreMapper.selectById(studentId);
    }

    /**
     * 分页查询所有的测验科目
     * @param page
     * @return
     */
    @Override
    public IPage<ExamManager> findAll(Page<ExamManager> page) {
        return scoreMapper.selectAll(page);
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

    /*@Override
    public List<Score> findAll() {
        return scoreMapper.selectAll();
    }

    @Override
    public IPage<Score> findById(Page<?> page, Integer studentId) {
        return scoreMapper.selectById(page, studentId);
    }*/
}
