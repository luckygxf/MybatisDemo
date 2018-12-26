package com.gxf.aop.cglib.demo1;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/25 4:51 PM
 **/
public class DaoProxy implements MethodInterceptor {

  @Override
  public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
    System.out.println("Before Method Invoke");
    proxy.invokeSuper(object, objects);
    System.out.println("After Method Invoke");

    return object;
  }

}