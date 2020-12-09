package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.Teacher;
import com.douma.service.TeacherService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 控制教师分页
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/teachers/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Teacher> teacherPage = new Page<>(page, size);
        IPage<Teacher> res = teacherService.findAll(teacherPage);
        return ApiResultHandler.buildApiResult(200, "分页成功", res);
    }

    /**
     * 通过 id 查询出需要修改的教师信息
     * @return
     */
    @GetMapping("/teacher/{teacherId}")
    public ApiResult findById(@PathVariable("teacherId") Integer teacherId){
        Teacher res = teacherService.findById(teacherId);
        if (res != null){
            return ApiResultHandler.buildApiResult(200,"查找成功", res);
        }else {
            return ApiResultHandler.buildApiResult(401,"查找失败", null);
        }
    }

    /**
     * 控制修改教师
     * @param teacher
     * @return
     */
    @PutMapping("/teacher")
    public ApiResult save(@RequestBody Teacher teacher){
        int res = teacherService.save(teacher);
        if (res == 1){
            return ApiResultHandler.buildApiResult(200, "成功修改", res);
        }else {
            return ApiResultHandler.buildApiResult(200, "成功修改", res);
        }
    }

    @DeleteMapping("/teacher/{teacherId}")
    public ApiResult remove(@PathVariable("teacherId") Integer teacherId){
        int res = teacherService.removeById(teacherId);

        if (res == 1){
            return ApiResultHandler.buildApiResult(200, "成功删除", res);
        }else {
            return ApiResultHandler.buildApiResult(200, "删除失败", res);
        }
    }

    @PostMapping("/teacher")
    public ApiResult add(@RequestBody Teacher teacher){
        int res = teacherService.add(teacher);
        if (res == 1){
            return ApiResultHandler.buildApiResult(200, "添加成功", res);
        }else {
            return ApiResultHandler.buildApiResult(200, "添加失败", res);
        }
    }



}
