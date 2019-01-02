package com.gxf.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/2 7:58 PM
 **/
public class StudentMapper implements RowMapper<Student> {
  private static Logger logger = LoggerFactory.getLogger(StudentMapper.class);

  @Override
  public Student mapRow(ResultSet resultSet, int i) throws SQLException {
    Student student = new Student();
    student.setId(resultSet.getInt("id"));
    student.setName(resultSet.getString("name"));
    student.setAge(resultSet.getInt("age"));
    logger.info("student = {}, i = {}", student, i);
    return student;
  }
}
