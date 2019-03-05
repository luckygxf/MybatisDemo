package com.gxf.util;

import com.gxf.test.Student;
import com.gxf.test.Teacher;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/22 11:22 AM
 **/
public class Main {

  public static void main(String[] args) throws Exception {
    Student s = new Student("guanxianseng", 18);
    Teacher t = Teacher.copyFromStudent(s);
    System.out.println(t);
  }

  private static void testCopyBean() throws Exception{
    Student s = new Student("guanxianseng", 18);
    Class teacherClass = Teacher.class;
    Constructor<Teacher> teacherConstructor = teacherClass.getDeclaredConstructor(null);
    Teacher teacher = teacherConstructor.newInstance();
    Field[] studentFields = s.getClass().getDeclaredFields();
    for (Field field : studentFields) {
      System.out.println(field.getName());
      Field teacherField = teacherClass.getDeclaredField(field.getName());
      teacherField.setAccessible(true);
      field.setAccessible(true);
      teacherField.set(teacher, field.get(s));
    }
    System.out.println(teacher);
  }
}
