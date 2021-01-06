package com.douma.mapper;

import com.douma.entity.MultiQuestion;
import com.douma.entity.PaperManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperManagerMapper {

    /**
     * 添加 paperManager 对象
     * @param
     * @return
     */
//    @Insert("insert into paper_manage(paperId,questionType,questionId) values " +
//            "(#{paperId},#{questionType},#{questionId})")
//    int insert(PaperManager paperManager);
    Integer insert(PaperManager paperManager);

    /**
     * 通过 paperId 查询试卷
     * @param
     * @return
     */
//    @Select("select paperId, questionType,questionId from paper_manage where paperId = #{paperId}")
//    List<PaperManager> selectByPaperId(Integer paperId);
    List<PaperManager> selectByPaperId(Integer paperId);


/*
    @Insert({
            "<script>",
            "insert into paper_manage(paperId,questionType,questionId) values ",
            "<foreach collection='list' item='item' index='index' separator=','>",
            "(#{item.paperId}, #{item.questionType}, #{item.questionId})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(List<PaperManager> paperManager);
*/
    int batchInsert(List<PaperManager> paperManager);
}
