package com.douma.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.ApiResult;
import com.douma.entity.Message;
import com.douma.service.MessageService;
import com.douma.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/message")
    public ApiResult add(@RequestBody Message message){
        int res = messageService.add(message);
        return ApiResultHandler.buildApiResult(200, "成功添加", res);
    }

    @GetMapping("/messages/{page}/{size}")
    public ApiResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<Message> messagePage = new Page<>(page, size);
        IPage<Message> res = messageService.findAll(messagePage);

        return ApiResultHandler.buildApiResult(200, "成功查询", res);
    }

}
