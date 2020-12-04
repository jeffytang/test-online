package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.Student;
import com.douma.service.StudentService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students/{page}/{size}")
    public ApiResult getStudentInfo(@PathVariable Integer page, @PathVariable Integer size){
        Page<Student> studentPage = new Page<>(page, size);
        IPage<Student> res = studentService.getStudentInfo(studentPage);
        return ApiResultHandler.buildApiResult(200, "分页查询所有学生", res);
    }

}
