package com.douma.service;

import com.douma.entity.JudgeQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface JudgeQuestionService {
    /**
     * 添加一个题目
     * @param judgeQuestion
     * @return
     */
    int add(JudgeQuestion judgeQuestion);

    /**
     * 查找最后一条记录的 id
     * @return
     */
    JudgeQuestion findByOnlyQuestionId();
}
