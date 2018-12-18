package com.gxf.ioc.parent_beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring_ioc/parentbeans.xml");

//    HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
//
//    objA.getMessage1();
//    objA.getMessage2();

    HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
    objB.getMessage1();
    objB.getMessage2();
    objB.getMessage3();
  }
}