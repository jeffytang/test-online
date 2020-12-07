package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.TestPaper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ExamMapper {
    /**
     * 分页查询所有的测验科目(对 exam_manager 表进行分页)
     * @param page
     * @return
     */
    @Select("select * from exam_manager")
    IPage<ExamManager> selectAll(Page page);

    /**
     * 查询最后一条记录
     * @return
     */
    @Select("select paperId from exam_manager order by paperId desc limit 1")
    ExamManager selectByPaperId();

    /**
     * 添加一场考试
     * @param examManager
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "examCode")
    @Insert("insert into exam_manager(" +
            "description,source,paperId,examDate,totalTime," +
            "grade,term,major,institute,totalScore,type,tips)" +
            " values(#{description},#{source},#{paperId}," +
            "#{examDate},#{totalTime},#{grade},#{term},#{major}," +
            "#{institute},#{totalScore},#{type},#{tips})")
    int insert(ExamManager examManager);

    /**
     * 根据考试编码查找试卷信息
     * @param examCode
     * @return
     */
    @Select("select * from exam_manager where examCode = #{examCode}")
    ExamManager selectByExamCode(Integer examCode);

    /**
     *更新试卷的数据
     * @param examManager
     * @return
     */
    @Update("update exam_manager set description = #{description},source = #{source},paperId = #{paperId}," +
            "examDate = #{examDate},totalTime = #{totalTime},grade = #{grade},term = #{term}," +
            "major = #{major},institute = #{institute},totalScore = #{totalScore}," +
            "type = #{type},tips = #{tips} where examCode = #{examCode}")
    int update(ExamManager examManager);

    /**
     *删除试卷信息
     * @param examCode
     * @return
     */
    @Delete("delete from exam_manager where examCode = #{examCode}")
    int delete(Integer examCode);
}
