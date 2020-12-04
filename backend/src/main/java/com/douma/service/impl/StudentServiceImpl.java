package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Student;
import com.douma.mapper.StudentMapper;
import com.douma.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    /**
     * 实现接口的方法调用持久层数据
     */
    @Override
    public IPage<Student> getStudentInfo(Page<Student> page) {
        return studentMapper.getStudentInfo(page);
    }

}
