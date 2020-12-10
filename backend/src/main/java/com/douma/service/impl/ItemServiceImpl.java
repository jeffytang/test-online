package com.douma.service.impl;

import com.douma.entity.ItemManager;
import com.douma.entity.PaperManager;
import com.douma.mapper.FillQuestionMapper;
import com.douma.mapper.JudgeQuestionMapper;
import com.douma.mapper.MultiQuestionMapper;
import com.douma.mapper.PaperManagerMapper;
import com.douma.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    /*@Autowired
    private FillQuestionService fillQuestionMapper;
    @Autowired
    private JudgeQuestionService judgeQuestionMapper;
    @Autowired
    private MultiQuestionService multiQuestionMapper;*/

    @Autowired
    private FillQuestionMapper fillQuestionMapper;
    @Autowired
    private JudgeQuestionMapper judgeQuestionMapper;
    @Autowired
    private MultiQuestionMapper multiQuestionMapper;
    @Autowired
    private PaperManagerService paperManagerService;

    @Override
    public void autoGenPaper(ItemManager item) {
        Integer changeNumber = item.getChangeNumber();
        Integer fillNumber = item.getFillNumber();
        Integer judgeNumber = item.getJudgeNumber();
        Integer paperId = item.getPaperId();

        List<PaperManager> list = new ArrayList<>();

        // 1. 随机选择指定个数的选择题，生成试卷
        List<Integer> selectNumbers = multiQuestionMapper.findBySubject(item.getSubject(), changeNumber);
        if (selectNumbers == null || selectNumbers.isEmpty()) {
            throw new RuntimeException("选择题数据库获取失败");
        }
        for (Integer number : selectNumbers) {
            list.add(new PaperManager(paperId,2,number));
        }

        // 2. 随机选择指定个数用的填空题，生成试卷
        List<Integer> fillNumbers = fillQuestionMapper.findBySubject(item.getSubject(), fillNumber);
        if (fillNumbers == null || fillNumbers.isEmpty()){
            throw new RuntimeException("填空题数据库获取失败");
        }
        for (Integer number : fillNumbers) {
            list.add(new PaperManager(paperId,1,number));
        }

        // 3. 随机选择指定个数用的判断题，生成试卷
        List<Integer> judgeNumbers = judgeQuestionMapper.findBySubject(item.getSubject(), judgeNumber);
        if (judgeNumbers == null || judgeNumbers.isEmpty()){
            throw new RuntimeException("判断题数据库获取失败");
        }
        for (Integer number : judgeNumbers) {
            list.add(new PaperManager(paperId,3,number));
        }

        /*for (PaperManager paperManager : list) {
            // TODO 使用批量插入，性能更好
            paperManagerService.add(paperManager);
        }*/
        paperManagerService.batchInsert(list);
    }
}
