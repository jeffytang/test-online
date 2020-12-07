package com.douma.controller;

import com.douma.entity.ApiResult;
import com.douma.entity.MultiQuestion;
import com.douma.service.MultiQuestionService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiQuestionController {
    @Autowired
    private MultiQuestionService multiQuestionService;

    @PostMapping("/MultiQuestion")
    public ApiResult add(@RequestBody MultiQuestion multiQuestion){
        int res = multiQuestionService.add(multiQuestion);
        return ApiResultHandler.buildApiResult(200, "添加成功", res);
    }

    @GetMapping("/multiQuestionId")
    public ApiResult findByMultiQuestionId(){
        MultiQuestion res = multiQuestionService.findByOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查找成功", res);
    }


}
