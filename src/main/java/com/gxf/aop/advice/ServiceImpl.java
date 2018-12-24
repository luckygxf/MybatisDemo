package com.gxf.aop.advice;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/24 8:59 PM
 **/
public class ServiceImpl implements Service {

  public void print(String str) {
    System.out.println("我是业务方法"+str);
  }
}
