package com.gxf.mvc.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/20 11:47 AM
 **/
public class TestCreateBean {

  public static void main(String[] args) {
    DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
    Person person = defaultListableBeanFactory.createBean(Person.class);
    System.out.println("person: " + person);
  }
}
