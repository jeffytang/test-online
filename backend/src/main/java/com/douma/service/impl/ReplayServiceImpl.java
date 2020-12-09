package com.douma.service.impl;

import com.douma.entity.Replay;
import com.douma.mapper.ReplayMapper;
import com.douma.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplayServiceImpl implements ReplayService {
    @Autowired
    private ReplayMapper replayMapper;

    @Override
    public int add(Replay replay) {
        return replayMapper.insert(replay);
    }

    @Override
    public List<Replay> findAllById(Integer messageId) {
        return replayMapper.findAllById(messageId);
    }
}
