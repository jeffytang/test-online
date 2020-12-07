package com.douma.controller;

import com.douma.entity.ApiResult;
import com.douma.entity.JudgeQuestion;
import com.douma.service.JudgeQuestionService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeQuestionController {
    @Autowired
    private JudgeQuestionService judgeQuestionService;

    @PostMapping("/judgeQuestion")
    public ApiResult add(@RequestBody JudgeQuestion judgeQuestion){
        int res = judgeQuestionService.add(judgeQuestion);
        return ApiResultHandler.buildApiResult(200,"添加成功", res);
    }

    @GetMapping("/judgeQuestionId")
    public ApiResult findByOnlyQuestionId(){
        JudgeQuestion res = judgeQuestionService.findByOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查询成功", res);
    }
}
