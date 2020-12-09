package com.douma.service.impl;

import com.douma.entity.JudgeQuestion;
import com.douma.mapper.JudgeQuestionMapper;
import com.douma.service.JudgeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeQuestionServiceImpl implements JudgeQuestionService {
    @Autowired
    private JudgeQuestionMapper judgeQuestionMapper;

    /**
     * 添加一条记录
     * @param judgeQuestion
     * @return
     */
    @Override
    public int add(JudgeQuestion judgeQuestion) {
        return judgeQuestionMapper.insert(judgeQuestion);
    }

    /**
     * 查找最后一条id
     * @return
     */
    @Override
    public JudgeQuestion findByOnlyQuestionId() {
        return judgeQuestionMapper.selectByOnlyQuestionId();
    }

//    @Override
//    public List<JudgeQuestion> selectByPaperId(Integer paperId) {
//        return judgeQuestionMapper.selectByPaperId(paperId);
//    }
}
