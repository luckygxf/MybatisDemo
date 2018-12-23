package com.gxf.mvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/22 4:31 PM
 **/
public class HandlerInterceptor2 implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("HandlerInterceptor2....preHandle");
    //false表示拦截，不向下执行；true表示放行
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("HandlerInterceptor2....postHandle");

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    System.out.println("HandlerInterceptor2....afterCompletion");
  }
}