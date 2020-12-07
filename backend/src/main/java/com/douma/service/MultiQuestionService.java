package com.douma.service;

import com.douma.entity.MultiQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MultiQuestionService {
    /**
     * 添加试题
     * @param multiQuestion
     * @return
     */
    int add(MultiQuestion multiQuestion);

    /**
     * 查找最后的一条题目id
     * @return
     */
    MultiQuestion findByOnlyQuestionId();
}
