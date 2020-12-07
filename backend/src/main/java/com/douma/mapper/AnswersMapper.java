package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.FillQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnswersMapper {

    /**
     * 分页
     * @param page
     * @return
     */
    @Select("select question, subject, score, section,level, \"选择题\" as type from multi_question\n" +
            "union select  question, subject, score, section,level, \"判断题\" as type from judge_question\n" +
            "union select  question, subject, score, section,level, \"填空题\" as type from fill_question")
    IPage<FillQuestion> selectAll(Page page);
}
