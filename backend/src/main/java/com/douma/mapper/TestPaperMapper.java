package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import org.apache.ibatis.annotations.Select;

public interface TestPaperMapper {
    /**
     * 分页查询所有的测验科目(对 exam_manager 表进行分页)
     * @param page
     * @return
     */
    @Select("select * from exam_manager")
    IPage<ExamManager> selectAll(Page page);

}
