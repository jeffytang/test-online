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
        return studentMapper.selectAll(page);
    }

    @Override
    public Student findById(Integer studentId) {
        return studentMapper.selectById(studentId);
    }

    /**
     * 实现插入一个学生
     */
    @Override
    public boolean save(Student student) {
        return studentMapper.insert(student);
    }

    /**
     * 删除学生信息
     * @param studentId
     * @return
     */
    @Override
    public int removeById(Integer studentId) {
        return studentMapper.deleteById(studentId);
    }

    @Override
    public int savePwd(Student student) {
        return studentMapper.updatePwd(student);
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public int modify(Student student) {
        return studentMapper.update(student);
    }


}
