package com.douma.controller;

import com.douma.entity.ApiResult;
import com.douma.entity.PaperManager;
import com.douma.service.PaperManagerService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaperManagerController {
    @Autowired
    private PaperManagerService paperManagerService;

    @PostMapping("/paperManage")
    public ApiResult add(@RequestBody PaperManager paperManage){
        int res = paperManagerService.add(paperManage);
        return ApiResultHandler.buildApiResult(200, "添加成功", res);
    }
}
