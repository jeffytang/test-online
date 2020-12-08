package com.douma.service;

import com.douma.entity.FillQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 根据传回的paperId 查询填空题的数量
     * @param paperId
     * @return
     */
//    List<FillQuestion> findByPaperId(Integer paperId);
}
