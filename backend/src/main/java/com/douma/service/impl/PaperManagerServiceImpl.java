package com.douma.service.impl;

import com.douma.entity.FillQuestion;
import com.douma.entity.JudgeQuestion;
import com.douma.entity.MultiQuestion;
import com.douma.entity.PaperManager;
import com.douma.mapper.FillQuestionMapper;
import com.douma.mapper.JudgeQuestionMapper;
import com.douma.mapper.MultiQuestionMapper;
import com.douma.mapper.PaperManagerMapper;
import com.douma.service.PaperManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperManagerServiceImpl implements PaperManagerService {
    @Autowired
    private FillQuestionMapper fillQuestionMapper;
    @Autowired
    private MultiQuestionMapper multiQuestionMapper;
    @Autowired
    private JudgeQuestionMapper judgeQuestionMapper;
    @Autowired
    private PaperManagerMapper paperManagerMapper;

    @Override
    public int add(PaperManager paperManager) {
        return paperManagerMapper.insert(paperManager);
    }



    @Override
    public Map<Integer, List<?>> findByPaperId(Integer paperId) {
        List<FillQuestion> fillQuestions = fillQuestionMapper.selectByPaperId(paperId);
        List<MultiQuestion> multiQuestions = multiQuestionMapper.selectByPaperId(paperId);
        List<JudgeQuestion> judgeQuestions= judgeQuestionMapper.selectByPaperId(paperId);

        Map<Integer, List<?>> map = new HashMap<>();
        map.put(1,multiQuestions);
        map.put(2,fillQuestions);
        map.put(3,judgeQuestions);
        return map;
    }

}
