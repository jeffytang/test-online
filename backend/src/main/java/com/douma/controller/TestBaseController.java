package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.FillQuestion;
import com.douma.service.TestBaseService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBaseController {
    @Autowired
    private TestBaseService testBaseService;

    @GetMapping("/answers/{page}/{size}")
    public ApiResult answers(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<FillQuestion> questionPage = new Page<>(page, size);
        IPage res = testBaseService.findAll(questionPage);
        if (res != null){
            return ApiResultHandler.buildApiResult(200,"分页成功", res);
        }else {
            return ApiResultHandler.buildApiResult(200,"失败", null);
        }
    }
}
