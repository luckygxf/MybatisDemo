package com.gxf.mybatis.spring_property_edit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/11 10:24 AM
 **/
public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring_property_edit.xml");
    Order order = (Order) context.getBean(Order.class);
    System.out.println("order: " + order);

  }
}
