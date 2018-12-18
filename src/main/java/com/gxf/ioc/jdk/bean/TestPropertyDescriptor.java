package com.gxf.ioc.jdk.bean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/14 7:50 AM
 **/
public class TestPropertyDescriptor {

  public static void main(String[] args) {
    try {
      Class clazz = Class.forName("com.gxf.ioc.jdk.bean.Price");
      Object obj =  clazz.newInstance();
      System.out.println(obj);
      Field[] fields = clazz.getDeclaredFields();
      //写数据，即获得写方法（setter方法）给属性赋值
      for(Field f : fields){
        PropertyDescriptor pd = new PropertyDescriptor(f.getName(),clazz);
        Method method = pd.getWriteMethod();
        method.invoke(obj,"100元");
      }
      System.out.println(obj.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
