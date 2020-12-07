package com.douma.service.impl;

import com.douma.entity.MultiQuestion;
import com.douma.mapper.MultiQuestionMapper;
import com.douma.service.MultiQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiQuestionServiceImpl implements MultiQuestionService {
    @Autowired
    private MultiQuestionMapper multiQuestionMapper;

    /**
     * 添加试题
     * @param multiQuestion
     * @return
     */
    @Override
    public int add(MultiQuestion multiQuestion) {
        return multiQuestionMapper.insert(multiQuestion);
    }

    /**
     * 查找最后的一条题目id
     * @return
     */
    @Override
    public MultiQuestion findByOnlyQuestionId() {
        return multiQuestionMapper.selectByOnlyQuestionId();
    }
}
