package com.douma.mapper;

import com.douma.entity.Replay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplayMapper {

    /**
     * 添加一条留言回复
     * @param replay
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "replayId")
    @Insert("insert into replay(messageId,replay,replayTime) values(#{messageId}, #{replay},#{replayTime})")
    int insert(Replay replay);

    /**
     * 查找所有的留言回复（这条查找信息是给 messageMapper 用的）
     * @return
     */
    @Select("select messageId,replayId,replay,replayTime from replay where messageId = #{messageId}")
    List<Replay> findAllById(Integer messageId);
}
