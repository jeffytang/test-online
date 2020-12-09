package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Message;
import com.douma.mapper.MessageMapper;
import com.douma.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 添加一条留言
     * @param message
     * @return
     */
    @Override
    public int add(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public IPage<Message> findAll(Page<Message> page) {
        return messageMapper.selectAll(page);
    }
}
