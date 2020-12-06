package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QueryScoreMapper {

    /**
     * 通过 id 查询成绩
     */
    @Select("select etScore from score where studentId = #{studentId}")
    List<Score> selectById(Integer studentId);

    /**
     * 分页查询所有的测验科目(对 exam_manager 表进行分页)
     * @param page
     * @return
     */
    @Select("select * from exam_manager")
    IPage<ExamManager> selectAll(Page page);

    /**
     *查询学生学科的分数
     * @param ExamCode
     * @return
     */
    @Select("select * from score where examCode = #{ExamCode}")
    List<Score> selectByExamCode(Integer ExamCode);

    /**
     * 查询所有的成绩信息
     * 帮助功能模块的分页
     * @return
     *//*
    @Select("select scoreId,examCode,studentId,subject,ptScore,etScore,score,answerDate from score order by scoreId desc")
    List<Score> selectAll();

    @Select("select scoreId,examCode,studentId,subject,ptScore,etScore,score,answerDate from score where studentId = #{studentId} order by scoreId desc")
    IPage<Score> selectById(Page<?> page, Integer studentId);*/
}
