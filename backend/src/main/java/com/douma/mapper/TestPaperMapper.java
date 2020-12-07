package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.TestPaper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestPaperMapper {
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

}
