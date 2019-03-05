package com.gxf.aop.aop_annotation1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/22 2:17 PM
 **/
public class Main {

  public static void main(String[] args) throws Exception{
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_aop/spring_annotation1.xml");
    Performance performance = context.getBean(Performance.class);
    Person person = new Person("guanxianseng", 18);
    int order = 1;
    performance.perform(person, order);
  }
}
