package com.gxf.ioc.spring_order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/16 5:54 PM
 **/
public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.gxf.ioc.spring_order");
  }
}
