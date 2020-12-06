package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.FillQuestion;

public interface TestBaseService {

    /**
     * 分页
     * @param page
     * @return
     */
    IPage findAll(Page<FillQuestion> page);
}
