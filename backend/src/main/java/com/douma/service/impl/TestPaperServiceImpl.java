package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.TestPaper;
import com.douma.mapper.TestPaperMapper;
import com.douma.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPaperServiceImpl implements TestPaperService{
    @Autowired
    private TestPaperMapper testPaperMapper;

    /**
     * 分页查询所有的测验科目
     * @param page
     * @return
     */
    @Override
    public IPage<ExamManager> findAll(Page<ExamManager> page) {
        return testPaperMapper.selectAll(page);
    }

    /**
     * 查询最后一条记录
     * @return
     */
    @Override
    public ExamManager findByPaperId() {
        return testPaperMapper.selectByPaperId();
    }

    /**
     * 添加一场考试
     * @param examManager
     * @return
     */
    @Override
    public int add(ExamManager examManager) {
        return testPaperMapper.insert(examManager);
    }



}
