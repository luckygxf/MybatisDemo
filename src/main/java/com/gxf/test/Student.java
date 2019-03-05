package com.gxf.test;

import java.lang.reflect.Field;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/22 11:21 AM
 **/
public class Student {
  private String name;
  private int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
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
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }


  public static void main(String[] args) {
    Field[] declaredFields = Student.class.getDeclaredFields();
    for (Field field : declaredFields) {
      System.out.print(field.getName() + " ");
    }
    System.out.println();
    Field[] fields = Student.class.getFields();
    for (Field field : fields) {
      System.out.print(field.getName() + " ");
    }
  }
}
