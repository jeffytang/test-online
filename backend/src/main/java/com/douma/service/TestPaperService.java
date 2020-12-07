package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.TestPaper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TestPaperService {

    /**
     * 分页查询所有的测验科目
     * @param page
     * @return
     */
    IPage<ExamManager> findAll(Page<ExamManager> page);

    /**
     * 查询最后一条记录
     * @return
     */
    ExamManager findByPaperId();

    /**
     * 添加一场考试
     * @param examManager
     * @return
     */
    int add(ExamManager examManager);
}
