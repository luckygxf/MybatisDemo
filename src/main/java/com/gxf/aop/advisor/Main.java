package com.gxf.aop.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/25 5:24 PM
 **/
public class Main {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring_aop/spring_advisor.xml");
    UserService userService = applicationContext.getBean(UserService.class);
    userService.addUser();
  }
}
