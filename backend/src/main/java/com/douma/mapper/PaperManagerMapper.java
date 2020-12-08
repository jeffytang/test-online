package com.douma.mapper;

import com.douma.entity.MultiQuestion;
import com.douma.entity.PaperManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 通过 paperId 查询试卷
     * @param paperId
     * @return
     */
    @Select("select paperId, questionType,questionId from paper_manage where paperId = #{paperId}")
    List<PaperManager> selectByPaperId(Integer paperId);
}
