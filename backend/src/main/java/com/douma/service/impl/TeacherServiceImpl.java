package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Teacher;
import com.douma.mapper.TeacherMapper;
import com.douma.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 分页查找教师信息实现
     * @param page
     * @return
     */
    @Override
    public IPage findAll(Page page) {
        return teacherMapper.selectAll(page);
    }

    /**
     * 通过 id 查询 教师信息呈现在修改的表单中，配合 save 方法一起使用
     * @param teacherId
     * @return
     */
    @Override
    public Teacher findById(Integer teacherId) {
        return teacherMapper.selectById(teacherId);
    }

    /**
     * 修改教师信息（需要通过 通过页面点击修改教师信息 获取到教师信息才能对信息进行修改）
     * @param teacher
     * @return
     */
    @Override
    public int save(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    /**
     * 删除教师信息
     * @param teacherId
     * @return
     */
    @Override
    public int removeById(Integer teacherId) {
        return teacherMapper.deleteById(teacherId);
    }

    /**
     * 插入教师信息
     * @param teacher
     * @return
     */
    @Override
    public int add(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }


}
