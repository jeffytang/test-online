package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.FillQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestBaseMapper {

    /**
     * 分页
     * @param page
     * @return
     */
    @Select("select * from fill_question as f join judge_question as j on j.score = f.score")
    IPage<FillQuestion> selectAll(Page page);
}
