package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.Student;
import com.douma.service.StudentService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/students/{page}/{size}")
    public ApiResult getStudentInfo(@PathVariable Integer page, @PathVariable Integer size){
        Page<Student> studentPage = new Page<>(page, size);
        IPage<Student> res = studentService.getStudentInfo(studentPage);
        return ApiResultHandler.buildApiResult(200, "分页查询所有学生", res);
    }

    @PostMapping("/student")
    public ApiResult saveStudent(@RequestBody Student student){
        boolean res = studentService.updateStudent(student);
        if (res){
            return ApiResultHandler.buildApiResult(200, "新增一个学生", res);
        }else {
            return ApiResultHandler.buildApiResult(401, "请求失败", res);
        }

    }

}
