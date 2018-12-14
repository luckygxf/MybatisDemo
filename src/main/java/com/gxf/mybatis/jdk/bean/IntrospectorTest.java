package com.gxf.mybatis.jdk.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/14 8:13 AM
 **/
public class IntrospectorTest {
  public static void demo2() throws Exception {
    User user = new User("guanxianseng", 28);
    // 获取整个Bean的信息
    // BeanInfo beanInfo= Introspector.getBeanInfo(user.getClass());
    // 在Object类时候停止检索，可以选择在任意一个父类停止
    BeanInfo beanInfo = Introspector.getBeanInfo(user.getClass(), Object.class);

    System.out.println("所有属性描述：");
    // 获取所有的属性描述
    PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
    for (PropertyDescriptor propertyDescriptor : pds) {
      System.out.println(propertyDescriptor.getName());
    }
    System.out.println("所有方法描述：");
    for (MethodDescriptor methodDescriptor : beanInfo.getMethodDescriptors()) {
      System.out.println(methodDescriptor.getName());
      // Method method = methodDescriptor.getMethod();
    }
  }


  public static void main(String[] args) throws Exception {
    demo2();
  }
}
