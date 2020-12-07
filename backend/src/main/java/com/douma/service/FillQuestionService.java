package com.douma.service;

import com.douma.entity.FillQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface FillQuestionService {
    /**
     * 添加题目
     * @param fillQuestion
     * @return
     */
    int add(FillQuestion fillQuestion);

    /**
     * 查找最后的一条题目id
     * @return
     */
    FillQuestion findOnlyQuestionId();
}
