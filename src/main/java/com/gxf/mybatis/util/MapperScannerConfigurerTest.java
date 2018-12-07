package com.gxf.mybatis.util;

import com.gxf.mybatis.mapper.PersonMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/6 7:53 PM
 **/
public class MapperScannerConfigurerTest {

  public static void main(String[] args) {
    testSpringMybatis();
  }
  private static void testSpringMybatis(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    PersonMapper personMapper = (PersonMapper) applicationContext.getBean("personMapper");
    System.out.println("personMapper:" + personMapper);
  }
}
