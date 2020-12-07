package com.douma.mapper;

import com.douma.entity.FillQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FillQuestionMapper {

    /**
     * 添加题目
     * @param fillQuestion
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into fill_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject,},#{question},#{answer},#{analysis},#{level},#{section})")
    int insert(FillQuestion fillQuestion);


    /**
     * 查找最后的一条题目id
     * @return
     */
    @Select("select questionId from fill_question order by questionId desc limit 1")
    FillQuestion selectOnlyQuestionId();
}
