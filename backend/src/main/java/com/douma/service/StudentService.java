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
    IPage getStudentInfo(Page<Student> page);

    /**
     * 插入一个学生
     */
    boolean updateStudent(Student student);
}
