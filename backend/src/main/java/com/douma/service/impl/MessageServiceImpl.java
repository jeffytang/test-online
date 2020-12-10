package com.douma.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Message;
import com.douma.mapper.MessageMapper;
import com.douma.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public IPage<Message> findAll(Integer page, Integer size) {
        int offset = (page - 1) * size;
        List<Message> messages = messageMapper.selectAll(offset, size);
        Page<Message> p = new Page<>();
        p.setRecords(messages);
        p.setCurrent(page);
        p.setSize(size);
        p.setTotal(messageMapper.count());
        return p;
    }



}
