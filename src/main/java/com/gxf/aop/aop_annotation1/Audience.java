package com.gxf.aop.aop_annotation1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/22 2:14 PM
 **/
@Aspect
public class Audience {

  /**
   * 定义一个公共的切点
   */
  @Pointcut("execution(* com.gxf.aop.aop_annotation1.PerformanceImpl.perform(..)) && args(person, order)")
  public void performance(Person person, int order) {
  }

  /**
   * 目标方法执行之前调用
   */
  @Before(value = "performance(person,  order)", argNames = "person, order")
  public void silenceCellPhone(Person person, int order) {
    System.out.println("in silenceCellPhone : " + " person, " + person + ", start at order: " + order);
    person.setAge(19);
    order ++;
  }

//  /**
//   * 目标方法执行之前调用
//   */
//  @Before("performance()")
//  public void takeSeats() {
//    System.out.println("Taking seats");
//  }
//
//  /**
//   * 目标方法执行完后调用
//   */
//  @AfterReturning("performance()")
//  public void applause() {
//    System.out.println("CLAP CLAP CLAP");
//  }
//
  /**
   * 目标方法发生异常时调用
   */
  @AfterThrowing(value = "execution(* com.gxf.aop.aop_annotation1.PerformanceImpl.perform(..))", throwing = "ex")
  public void demandRefund(JoinPoint joinPoint, Throwable ex) {
    System.out.println("joinPoint.getArgs(): " + joinPoint.getArgs());
    System.out.println("Demanding a refund joinpoint: " + joinPoint + ", ex: " + ex);
  }

}
