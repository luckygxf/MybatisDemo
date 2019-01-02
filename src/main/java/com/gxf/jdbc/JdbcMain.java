package com.gxf.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/2 8:05 PM
 **/
public class JdbcMain {
  private static Logger logger = LoggerFactory.getLogger(JdbcMain.class);

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_jdbc/jdbc_demo.xml");
    StudentDao studentDao = context.getBean(StudentDaoImpl.class);
    Student student = studentDao.get(1);
    logger.info("student: {}", student);
  }
}
