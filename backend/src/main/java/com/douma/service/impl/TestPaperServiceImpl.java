package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.mapper.TestPaperMapper;
import com.douma.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPaperServiceImpl implements TestPaperService{
    @Autowired
    private TestPaperMapper testPaperService;

    @Override
    public IPage<ExamManager> findAll(Page<ExamManager> page) {
        return testPaperService.selectAll(page);
    }

    /**
     * 分页查询所有的测验科目
     * @param page
     * @return
     *//*
    @Override
    public IPage<ExamManager> findAll(Page<ExamManager> page) {
        return testPaperService.findAll(page);
    }*/

}
