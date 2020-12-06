package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.Score;
import org.apache.ibatis.annotations.Mapper;
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

}
