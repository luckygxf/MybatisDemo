package com.gxf.aop.declare_parent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/25 3:12 PM
 **/
public class Main {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring_aop/spring_declare_parent.xml");
    Chinese lilei = (Chinese)applicationContext.getBean("lilei");
    lilei.Say();

    Add lilei2 = (Add)applicationContext.getBean("lilei");
    lilei2.Todo();
  }
}
