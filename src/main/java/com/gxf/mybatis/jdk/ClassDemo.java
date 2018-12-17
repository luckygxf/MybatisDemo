package com.gxf.mybatis.jdk;

import java.lang.*;

public class ClassDemo {

  public static void main(String[] args) {

    try {
      // returns the Class object associated with this class
//      Class cls = Class.forName("com.gxf.mybatis.jdbc.ClassDemo");
      Class cls = ClassDemo.class;

        /* returns the array of Class objects representing all the declared
        members of this class */
      Class[] classes = cls.getDeclaredClasses();
      for (int i = 0; i < classes.length; i++) {
        System.out.println("Class = " + classes[i].getName());
      }
    }
    catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  public class InnerClass1 {
    public InnerClass1() {
      System.out.println("Inner Class1");
    }
  }

  public class InnerClass2 {
    public InnerClass2() {
      System.out.println("Inner Class2");
    }
  }

  private class InnerPrivateClass {
    public InnerPrivateClass() {
      System.out.println("Inner Private Class");
    }
  }
}