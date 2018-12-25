package com.gxf.aop.advisor;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/25 5:06 PM
 **/
public class LogBeforeAdvice implements MethodBeforeAdvice {

  @Override
  public void before(Method method, Object[] args, Object target) throws Throwable {
    System.out.println("===============before advice start==============");
    System.out.println("method: " + method);
    System.out.println("args: " + args);
    System.out.println("target: " + target);
    System.out.println("===============before advice end================");
    method.invoke(target, args);
    System.out.println("===============invoke===============");
  }

}