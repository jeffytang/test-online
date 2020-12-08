package com.douma.controller;

import com.douma.entity.ApiResult;
import com.douma.entity.ItemManager;
import com.douma.entity.PaperManager;
import com.douma.service.*;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/item")
    public ApiResult findByRandom(@RequestBody ItemManager itemManager){
        try {
            itemService.autoGenPaper(itemManager);
        } catch (RuntimeException e) {
            return ApiResultHandler.buildApiResult(400,e.getMessage(),null);
        }
        return ApiResultHandler.buildApiResult(200,"试卷组卷成功",null);
    }
}
