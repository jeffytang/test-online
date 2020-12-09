package com.douma.controller;

import com.douma.entity.ApiResult;
import com.douma.entity.PaperManager;
import com.douma.service.PaperManagerService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PaperManagerController {
    @Autowired
    private PaperManagerService paperManagerService;

    @PostMapping("/paperManage")
    public ApiResult add(@RequestBody PaperManager paperManage){
        int res = paperManagerService.add(paperManage);
        return ApiResultHandler.buildApiResult(200, "添加成功", res);
    }

    @GetMapping("/paper/{paperId}")
    public Map<Integer, List<?>> findByPaperId(@PathVariable Integer paperId){
        Map<Integer, List<?>> res =  paperManagerService.findByPaperId(paperId);
        return res;
    }
}
