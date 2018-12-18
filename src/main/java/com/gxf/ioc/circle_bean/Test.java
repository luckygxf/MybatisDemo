package com.gxf.ioc.circle_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 11:12 PM
 **/
public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring_ioc/cicle_beans.xml");
    StudentA studentA = context.getBean(StudentA.class);
    StudentB studentB = context.getBean(StudentB.class);
    StudentC studentC = context.getBean(StudentC.class);

    System.out.println("a: " + studentA);
    System.out.println("b: " + studentB);
    System.out.println("c: " + studentC);
  }
}
