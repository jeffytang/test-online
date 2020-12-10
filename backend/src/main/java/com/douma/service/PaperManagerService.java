package com.douma.service;

import com.douma.entity.PaperManager;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface PaperManagerService {
    /**
     * 添加 paperManager 对象
     * @param paperManager
     * @return
     */
    int add(PaperManager paperManager);

    /**
     * 通过 paperId 查询试卷
     * @param paperId
     * @return
     */
    Map<Integer, List<?>> findByPaperId(Integer paperId);

    int batchInsert(List<PaperManager> paperManager);
}
