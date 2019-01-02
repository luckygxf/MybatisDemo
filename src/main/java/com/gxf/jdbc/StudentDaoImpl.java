package com.gxf.jdbc;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/2 8:01 PM
 **/
public class StudentDaoImpl implements StudentDao {
  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  @Override
  public Student get(long id) {
    String sql = "select * from student where id = ?";
    Student student = jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
    return student;
  }

  public DataSource getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
