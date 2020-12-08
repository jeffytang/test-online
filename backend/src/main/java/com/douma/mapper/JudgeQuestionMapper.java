package com.douma.mapper;

import com.douma.entity.JudgeQuestion;
import com.douma.entity.MultiQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JudgeQuestionMapper {

    /**
     * 添加一个题目
     * @param judgeQuestion
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into judge_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject},#{question},#{answer},#{analysis},#{level},#{section})")
    int insert(JudgeQuestion judgeQuestion);

    /**
     * 查找最后一条记录的 id
     * @return
     */
    @Select("select questionId from judge_question order by questionId desc limit 1")
    JudgeQuestion selectByOnlyQuestionId();

    /**
     * 查找指定条数的记录
     * @return
     */
    @Select("select questionId from judge_question  where subject=#{subject}  order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(String subject,Integer pageNo);
}
