package com.gxf.aop.cglib.demo1;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/26 9:01 PM
 **/
public class TargetObject {
  public String method1(String paramName) {
    return paramName;
  }

  public int method2(int count) {
    return count;
  }

  public int method3(int count) {
    return count;
  }

  @Override
  public String toString() {
    return "TargetObject []"+ getClass();
  }
}