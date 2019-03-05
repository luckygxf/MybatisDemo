package com.gxf.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/22 11:22 AM
 **/
public class Teacher {
  private String name;
  private int age;
  private String title;

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public static Teacher copyFromStudent(Student s) {
    Field[] fields = s.getClass().getDeclaredFields();
    Class teacherClazz = Teacher.class;
    Teacher teacher = null;
    try {
      Constructor<Teacher> teacherConstructor = teacherClazz.getConstructor(null);
      teacher = teacherConstructor.newInstance(null);
      for (Field field : fields) {
        Field teacherField = teacherClazz.getDeclaredField(field.getName());
        field.setAccessible(true);
        teacherField.setAccessible(true);
        teacherField.set(teacher, field.get(s));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return teacher;
  }

  @Override
  public String toString() {
    return "Teacher{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", title='" + title + '\'' +
        '}';
  }
}
