package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface MessageMapper {
    /**
     * 添加一条留言
     * @param message
     * @return
     */
    /*@Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into message(title, content, time) values(#{title},#{content},#{time})")
    int insert(Message message);*/
    int insert(@Param("message") Message message);

    /**
     * 给学生留言分页，通过 @Many 注解控制查询条件(Many 中调用的方法余姚参数，而这边没有提供参数，试着删除，或者给该方法提供一个参数)
     * @param
     * @return
     */
    /*@Select("select id,id as temp_id,title,content,time from message order by id desc")
    @Results({
            @Result(property = "replays", column = "temp_id",many = @Many(select = "com.douma.mapper.ReplayMapper.findAllById"))
    })
    IPage<Message> selectAll(Page page);*/
    List<Message> selectAll(@Param("page") Integer page, @Param("size") Integer size);


    Integer count();


}
