package com.gxf.aop.cglib.demo1;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/26 9:02 PM
 **/
public class TargetInterceptor implements MethodInterceptor {

  /**
   * 重写方法拦截在方法前和方法后加入业务 Object obj为目标对象 Method method为目标方法 Object[] params 为参数， MethodProxy proxy
   * CGlib方法代理对象
   */
  @Override
  public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy)
      throws Throwable {
    Object result = null;
    System.out.println("调用前");
    result = proxy.invokeSuper(obj, params);
    System.out.println(" 调用后");
    System.out.println("  " + result);
    return result;
  }


}