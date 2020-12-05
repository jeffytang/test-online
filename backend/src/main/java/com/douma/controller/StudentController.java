package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.Student;
import com.douma.service.StudentService;
import com.douma.util.ApiResultHandler;
import org.apache.ibatis.annotations.Delete;
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
        IPage<Student> res = studentService.findAll(studentPage);
        return ApiResultHandler.buildApiResult(200, "分页查询所有学生", res);
    }

    @GetMapping("/student/{studentId}")
    public ApiResult findById(@PathVariable("studentId") Integer studentId) {
        Student res = studentService.findById(studentId);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
        }
    }

    /**
     * 插入一个学生
     * @param student
     * @return
     */
    @PostMapping("/student")
    public ApiResult saveStudent(@RequestBody Student student){
        boolean res = studentService.updateStudent(student);
        if (res){
            return ApiResultHandler.buildApiResult(200, "新增一个学生", res);
        }else {
            return ApiResultHandler.buildApiResult(401, "请求失败", res);
        }
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @PutMapping("/student")
    public ApiResult update(@RequestBody Student student){
        int res = studentService.update(student);
        if (res != 0){
            return ApiResultHandler.buildApiResult(200, "更新成功", res);
        }else {
            return ApiResultHandler.buildApiResult(200, "更新失败", res);
        }
    }

    @DeleteMapping("/student/{studentId}")
    public ApiResult delete(@PathVariable("studentId") Integer studentId){
        int res = studentService.deleteById(studentId);
        if (res == 1){
            return ApiResultHandler.buildApiResult(200, "删除失败", res);
        }else {
            return ApiResultHandler.buildApiResult(200, "删除成功", res);
        }

    }

}
