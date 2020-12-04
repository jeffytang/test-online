package com.douma.controller;

import com.douma.entity.*;
import com.douma.service.LoginService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    // 新建一个 Login 实体类，把 post 提交的 json 数据封装到类中
    public ApiResult login(@RequestBody Login login){
        Integer username = login.getUsername();
        String password = login.getPassword();
        Admin admin = loginService.adminLogin(username, password);
        if (admin != null){
            return ApiResultHandler.buildApiResult(200, "请求成功", admin);
        }

        Teacher teacher = loginService.teacherLogin(username, password);
        if (teacher != null){
            return ApiResultHandler.buildApiResult(200, "请求成功", teacher);
        }

        Student student = loginService.studentLogin(username, password);
        if (student != null){
            return ApiResultHandler.buildApiResult(200, "请求成功", student);
        }

        return ApiResultHandler.buildApiResult(401, "请求失败", null);
    }
}
