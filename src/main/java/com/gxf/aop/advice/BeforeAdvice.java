package com.gxf.aop.advice;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 9:00 PM
 **/
public class BeforeAdvice implements MethodBeforeAdvice {
  public void before(Method method, Object[] objects, Object o) throws Throwable {
    System.out.println("BeforeAdvice方法执行前");
    System.out.println(method.getName()+";"+o.getClass());
  }
}
