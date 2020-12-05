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
    public IPage<Student> findAll(Page<Student> page) {
        return studentMapper.findAll(page);
    }

    @Override
    public Student findById(Integer studentId) {
        return studentMapper.findById(studentId);
    }

    /**
     * 实现插入一个学生
     */
    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    /**
     * 删除学生信息
     * @param studentId
     * @return
     */
    @Override
    public int deleteById(Integer studentId) {
        return studentMapper.deleteById(studentId);
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }


}
