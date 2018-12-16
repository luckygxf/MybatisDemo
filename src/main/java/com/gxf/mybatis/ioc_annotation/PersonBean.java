package com.gxf.mybatis.ioc_annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/15 4:09 PM
 **/
//@Component
  @Service
public class PersonBean {
  private String name;
  private int age;

  public PersonBean() {
    name = "guanxianseng";
    age = 18;
  }

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

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
