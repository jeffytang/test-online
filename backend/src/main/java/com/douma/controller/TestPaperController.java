package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.ExamManager;
import com.douma.service.TestPaperService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPaperController {
    @Autowired
    private TestPaperService testPaperService;
    /**
     * 分页查询所有试卷信息
     */
    @GetMapping("/exams/{page}/{size}")
    public ApiResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<ExamManager> examManager = new Page<>(page,size);
        IPage<ExamManager> res = testPaperService.findAll(examManager);
        if (res != null){
            return ApiResultHandler.buildApiResult(200, "成功查询", res);
        }else {
            return ApiResultHandler.buildApiResult(403, "查询错误", null);
        }
    }

}
