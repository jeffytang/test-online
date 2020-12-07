package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.FillQuestion;
import com.douma.mapper.AnswersMapper;
import com.douma.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswersServiceImpl implements AnswersService {
    @Autowired
    private AnswersMapper testBaseMapper;
    /**
     * 分页
     * @param page
     * @return
     */
    @Override
    public IPage<FillQuestion> findAll(Page<FillQuestion> page) {
        return testBaseMapper.selectAll(page);
    }
}
