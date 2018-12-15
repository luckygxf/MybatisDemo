package com.gxf.mybatis.ioc_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/14 9:00 PM
 **/
public class TestMain {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
    //获取bean
    TestBean tb = (TestBean) context.getBean("testBean");
    tb.sayHello();
    System.out.println(tb);

    TestConfiguration testConfiguration = context.getBean(TestConfiguration.class);
    System.out.println("testConfiguration: " + testConfiguration);
  }
}