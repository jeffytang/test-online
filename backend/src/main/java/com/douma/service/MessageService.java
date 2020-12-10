package com.douma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Message;



public interface MessageService {
    /**
     * 添加一条留言
     * @param message
     * @return
     */
    int add(Message message);

    /**
     * 给学生留言分页，通过 @Many 注解控制查询条件
     * @param
     * @return
     */
    IPage<Message> findAll(Integer page, Integer size);

}
