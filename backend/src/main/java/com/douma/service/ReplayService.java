package com.douma.service;

import com.douma.entity.Replay;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface ReplayService {

    /**
     * 添加一条留言回复
     * @param replay
     * @return
     */
    int add(Replay replay);

    List<Replay> findAllById(Integer messageId);
}
