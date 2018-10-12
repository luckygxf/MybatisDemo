package com.gxf.mybatis.mapper;

import com.gxf.mybatis.beans.Student;

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
}
