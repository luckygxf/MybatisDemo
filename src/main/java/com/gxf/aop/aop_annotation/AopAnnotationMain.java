package com.gxf.aop.aop_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/27 9:57 AM
 **/
public class AopAnnotationMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring_aop/spring_annotation.xml");
    TestBean testBean = applicationContext.getBean(TestBean.class);
    testBean.test();
  }
}
