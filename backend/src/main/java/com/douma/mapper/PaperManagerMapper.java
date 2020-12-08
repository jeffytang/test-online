package com.douma.mapper;

import com.douma.entity.MultiQuestion;
import com.douma.entity.PaperManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaperManagerMapper {

    /**
     * 添加 paperManager 对象
     * @param paperManager
     * @return
     */
    @Insert("insert into paper_manage(paperId,questionType,questionId) values " +
            "(#{paperId},#{questionType},#{questionId})")
    int insert(PaperManager paperManager);


}
