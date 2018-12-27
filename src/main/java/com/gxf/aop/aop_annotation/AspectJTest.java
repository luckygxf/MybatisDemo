package com.gxf.aop.aop_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/27 8:39 AM
 **/
@Aspect
public class AspectJTest {

  @Pointcut("execution(* *.test(..))")
  public void test(){

  }

  @Before("test()")
  public void beforeTest(){
    System.out.println("before test");
  }

  @After("test()")
  public void afterTest(){
    System.out.println("after test");
  }

  @Around("test()")
  public Object aroundTest(ProceedingJoinPoint proceedingJoinPoint){
    System.out.println("around before");
    Object o = null;
    try {
      o = proceedingJoinPoint.proceed();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }
    return o;
  }

}
