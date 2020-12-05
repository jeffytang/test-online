package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Teacher;
import org.apache.ibatis.annotations.Delete;

public interface TeacherService {

    /**
     * 分页查找教师
     * @param page
     * @return
     */
    IPage findAll(Page page);

    /**
     * 通过 id 查询 教师信息呈现在修改的表单中，配合 save 方法一起使用
     * @param teacherId
     * @return
     */
    Teacher findById(Integer teacherId);

    /**
     * 更新教师数据（配合 selectById）
     * @param teacher
     * @return
     */
    int save(Teacher teacher);

    /**
     * 删除教师信息
     * @param teacherId
     * @return
     */
    int removeById(Integer teacherId);

    /**
     * 插入教师信息
     * @param teacher
     * @return
     */
    int add(Teacher teacher);
}
