package com.gxf.aop.advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 8:59 PM
 **/
public class AfterAdvice implements AfterReturningAdvice {

  public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
    System.out.println("AfterAdvice方法执行完成了");
    System.out.println(method.getName()+";"+o1.getClass());
  }
}
