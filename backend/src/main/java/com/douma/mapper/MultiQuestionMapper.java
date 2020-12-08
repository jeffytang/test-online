package com.douma.mapper;

import com.douma.entity.JudgeQuestion;
import com.douma.entity.MultiQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 查找指定条数的记录
     * @return
     */
    @Select("select questionId from multi_question  where subject =#{subject} order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(String subject,Integer pageNo);

    /**
     * 根据传回的paperId 查询选择题的数量
     * @param paperId
     * @return
     */
    @Select("select * from multi_question where questionId in " +
            "(select questionId from paper_manage where paperId = #{paperId})")
    List<MultiQuestion> selectByPaperId(Integer paperId);

}
