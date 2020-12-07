package com.douma.controller;

import com.douma.entity.ApiResult;
import com.douma.entity.FillQuestion;
import com.douma.service.FillQuestionService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FillQuestionController {
    @Autowired
    private FillQuestionService fillQuestionService;

    @PostMapping("/fillQuestion")
    public ApiResult add(@RequestBody FillQuestion fillQuestion){
        int res = fillQuestionService.add(fillQuestion);
        return ApiResultHandler.buildApiResult(200, "添加成功", res);
    }

    @GetMapping("/fillQuestionId")
    public ApiResult findByQuestionId(){
        FillQuestion res = fillQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查询成功", res);
    }
}
