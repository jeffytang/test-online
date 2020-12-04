package com.douma.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douma.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {

    /**
     * 分页查询所有试卷信息
     * （返回的是不是 student 集合？到时候试一下:"直接通过分页插件搞定了"）
     * @param page
     * @return  Student
     */
    @Select("select * from student")
    IPage<Student> getStudentInfo(Page page);

    /**
     * 添加一个学生
     */
    @Insert("INSERT INTO student(studentName,grade,major,clazz,institute,tel,email,pwd,sex,role)" +
            "VALUES(#{studentName}, #{grade}, #{major}, #{clazz}, #{institute}, #{tel}, #{email}, #{pwd}, #{sex}, #{role})")
    boolean updateStudent(Student student);
}
