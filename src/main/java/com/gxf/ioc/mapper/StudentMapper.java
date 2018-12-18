package com.gxf.ioc.mapper;

import com.gxf.ioc.beans.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: guanxianseng@163.com
 * @Description:
 * @Date: Created in : 2018/10/12 下午9:13
 **/
public interface StudentMapper {

    /**
     * 根据id查询
     * */
    Student getStudentById(int id);

    /**
     * 添加student
     * */
    int addStudent(Student student);

    /**
     * 根据id更新name字段
     * */
    int updateStudentName(@Param("name") String name, @Param("id") int id);
}
