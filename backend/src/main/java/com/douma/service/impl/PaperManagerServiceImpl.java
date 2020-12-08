package com.douma.service.impl;

import com.douma.entity.PaperManager;
import com.douma.mapper.PaperManagerMapper;
import com.douma.service.PaperManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperManagerServiceImpl implements PaperManagerService {
    @Autowired
    private PaperManagerMapper paperManagerMapper;

    @Override
    public int add(PaperManager paperManager) {
        return paperManagerMapper.insert(paperManager);
    }

}
