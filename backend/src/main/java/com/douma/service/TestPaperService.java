package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;

public interface TestPaperService {

    /**
     * 分页查询所有的测验科目
     * @param page
     * @return
     */
    IPage<ExamManager> findAll(Page<ExamManager> page);

}
