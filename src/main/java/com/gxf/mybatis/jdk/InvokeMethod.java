package com.gxf.mybatis.jdk;

import com.gxf.mybatis.ioc_annotation.TestBean;
import com.gxf.mybatis.ioc_annotation.TestConfiguration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/17 8:29 PM
 **/
public class InvokeMethod {

  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    Class configClazz = TestConfiguration.class;
    TestConfiguration testConfiguration = new TestConfiguration();
    Method[] methods = configClazz.getDeclaredMethods();
    for (Method method : methods){
      System.out.println(method.getName());
    }
    TestBean testBean = (TestBean) methods[0].invoke(testConfiguration, null);
    System.out.println("testBean: " + testBean);
  }
}
