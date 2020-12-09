package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ExamManager;
import com.douma.mapper.ExamMapper;
import com.douma.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;

    /**
     * 分页查询所有的测验科目
     * @param page
     * @return
     */
    @Override
    public IPage<ExamManager> findAll(Page<ExamManager> page) {
        return examMapper.selectAll(page);
    }

    /**
     * 不要忘记不分页返回的是一个 list 集合
     * @return
     */
    @Override
    public List<ExamManager> findAllUnPage() {
        return examMapper.findAllUnPage();
    }


    /**
     * 查询最后一条记录
     * @return
     */
    @Override
    public ExamManager findByPaperId() {
        return examMapper.selectByPaperId();
    }

    /**
     * 添加一场考试
     * @param examManager
     * @return
     */
    @Override
    public int add(ExamManager examManager) {
        return examMapper.insert(examManager);
    }

    /**
     * 根据考试编码查找试卷信息
     * @param examCode
     * @return
     */
    @Override
    public ExamManager findByExamCode(Integer examCode) {
        return examMapper.selectByExamCode(examCode);
    }

    /**
     *更新试卷的数据
     * @param examManager
     * @return
     */
    @Override
    public int save(ExamManager examManager) {
        return examMapper.update(examManager);
    }

    /**
     *删除试卷信息
     * @param examCode
     * @return
     */
    @Override
    public int move(Integer examCode) {
        return examMapper.delete(examCode);
    }


}
