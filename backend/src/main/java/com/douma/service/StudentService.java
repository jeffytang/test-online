package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Student;

public interface StudentService {
    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage findAll(Page<Student> page);

    /**
     * 通过id查询学生信息
     * @param studentId
     * @return
     */
    Student findById(Integer studentId);

    /**
     * 更新
     * @param student
     * @return
     */
    int modify(Student student);

    /**
     * 插入一个学生
     */
    boolean save(Student student);

    /**
     * 通过 id 删除学学生信息
     * @param studentId
     * @return
     */
    int removeById(Integer studentId);
}
