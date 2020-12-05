package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {

    /**
     * 分页查询所有试卷信息
     * （返回的是不是 student 集合？到时候试一下:"直接通过分页插件搞定了"）
     * @param page
     * @return  Student
     */
    @Select("select * from student")
    IPage<Student> findAll(Page page);

    /**
     * 添加一个学生
     */
    @Options(useGeneratedKeys = true,keyProperty = "studentId")
    @Insert("INSERT INTO student(studentName,grade,major,clazz,institute,tel,email,pwd,sex,role)" +
            "VALUES(#{studentName}, #{grade}, #{major}, #{clazz}, #{institute}, #{tel}, #{email}, #{pwd}, #{sex}, #{role})")
    boolean updateStudent(Student student);

    @Select("select * from student where studentId = #{studentId}")
    Student findById(Integer studentId);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Update("update student set studentName = #{studentName},grade = #{grade},major = #{major},clazz = #{clazz}," +
            "institute = #{institute},tel = #{tel},email = #{email},pwd = #{pwd},cardId = #{cardId},sex = #{sex},role = #{role}" +
            "where studentId = #{studentId}")
    int update(Student student);

    @Delete("delete from student where studentId = #{studentId}")
    int deleteById(Integer studentId);


}
