package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.entity.TestPaper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ExamService {

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

    /**
     * 根据考试编码查找试卷信息
     * @param examCode
     * @return
     */
    ExamManager findByExamCode(Integer examCode);

    /**
     *更新试卷的数据
     * @param examManager
     * @return
     */
    int save(ExamManager examManager);

    /**
     *删除试卷信息
     * @param examCode
     * @return
     */
    int move(Integer examCode);
}
