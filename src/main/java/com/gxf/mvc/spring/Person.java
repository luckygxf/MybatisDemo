package com.gxf.mvc.spring;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/20 11:47 AM
 **/
public class Person implements InitializingBean {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Person() {
    this.name = "guanxianseng";
    this.age = 18;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("this: " + this);
  }
}
