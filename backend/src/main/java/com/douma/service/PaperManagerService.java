package com.douma.service;

import com.douma.entity.PaperManager;

import java.util.List;

public interface PaperManagerService {
    /**
     * 添加 paperManager 对象
     * @param paperManager
     * @return
     */
    int add(PaperManager paperManager);
}
