package com.douma.mapper;

import com.douma.entity.MultiQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MultiQuestionMapper {

    /**
     * 添加试题
     * @param multiQuestion
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "questionId")
    @Insert("insert into multi_question(subject,question,answerA,answerB,answerC,answerD,rightAnswer,analysis,section,level) " +
            "values(#{subject},#{question},#{answerA},#{answerB},#{answerC},#{answerD},#{rightAnswer},#{analysis},#{section},#{level})")
    int insert(MultiQuestion multiQuestion);

    /**
     * 查找最后的一条题目id
     * @return
     */
    @Select("select questionId from multi_question order by questionId desc limit 1")
    MultiQuestion selectByOnlyQuestionId();
}
