package com.gxf.aop.cache;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 11:47 PM
 **/
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheMethodInterceptor implements MethodInterceptor
{

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable
  {
    System.out.println("begin MethodInterceptor");

    Object result = invocation.proceed();

    System.out.println("end MethodInterceptor");

    return result;
  }

}
