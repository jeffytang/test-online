package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherMapper {

    /**
     * 分页查找老师
     * @param page
     * @return
     */
    @Select("select * from teacher")
    IPage<Teacher> selectAll(Page page);

    /**
     * 通过 id 查询 教师信息呈现在修改的表单中，配合 update 方法一起使用
     * @param teacherId
     * @return
     */
    @Select("select * from teacher where teacherId = #{teacherId}")
    Teacher selectById(Integer teacherId);

    /**
     * 修改教师信息
     * @param teacher
     * @return
     */
    @Update("update teacher set teacherName = #{teacherName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId}," +
            "role = #{role},institute = #{institute},type = #{type} where teacherId = #{teacherId}")
    int update(Teacher teacher);

    /**
     * 删除教师信息
     * @param teacherId
     * @return
     */
    @Delete("delete from teacher where teacherId = #{teacherId}")
    int deleteById(Integer teacherId);

    /**
     * 添加教师信息
     * @param teacher
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "teacherId")
    @Insert("insert into teacher(teacherName,sex,tel,email,pwd,cardId,role,type,institute) " +
            "values(#{teacherName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role},#{type},#{institute})")
    int insert(Teacher teacher);
}
