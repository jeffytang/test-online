package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreMapper {

    /**
     * 通过 id 查询成绩
     */
    @Select("select etScore from score where studentId = #{studentId}")
    List<Score> selectByStudentId(Integer studentId);

    /**
     *查询学生学科的分数
     * @param ExamCode
     * @return
     */
    @Select("select * from score where examCode = #{ExamCode}")
    List<Score> selectByExamCode(Integer ExamCode);

    /**
     * @param score 添加一条成绩记录
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "scoreId")
    @Insert("insert into score(examCode,studentId,subject,ptScore,etScore,score,answerDate) " +
            "values(#{examCode},#{studentId},#{subject},#{ptScore},#{etScore},#{score},#{answerDate})")
    int insert(Score score);

    /**
     * 对查询的分数进行分页
     * @param page
     * @return
     */
    @Select("select * from score where studentId = #{studentId}")
    IPage<Score> selectAll(Page page, Integer studentId);
}
