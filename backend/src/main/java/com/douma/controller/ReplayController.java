package com.douma.controller;

import com.douma.entity.ApiResult;
import com.douma.entity.Replay;
import com.douma.service.ReplayService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplayController {
    @Autowired
    private ReplayService replayService;

    @PostMapping("/replay")
    public ApiResult add(@RequestBody Replay replay){
        int res = replayService.add(replay);
        return ApiResultHandler.buildApiResult(200, "成功添加", res);
    }

    @GetMapping("/replay/{messageId}")
    public ApiResult findAllById(@PathVariable("messageId") Integer messageId) {
        List<Replay> res = replayService.findAllById(messageId);
        return ApiResultHandler.buildApiResult(200,"根据messageId查询",res);
    }

}
