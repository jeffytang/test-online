package com.douma.service.impl;

import com.douma.entity.FillQuestion;
import com.douma.mapper.FillQuestionMapper;
import com.douma.service.FillQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillQuestionServiceImpl implements FillQuestionService {
    @Autowired
    private FillQuestionMapper fillQuestionMapper;

    @Override
    public int add(FillQuestion fillQuestion) {
        return fillQuestionMapper.insert(fillQuestion);
    }

    @Override
    public FillQuestion findOnlyQuestionId() {
        return fillQuestionMapper.selectOnlyQuestionId();
    }

    /*@Override
    public List<FillQuestion> findByPaperId(Integer paperId) {
        return fillQuestionMapper.selectByPaperId(paperId);
    }*/
}
