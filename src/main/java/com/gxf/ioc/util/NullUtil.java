package com.gxf.ioc.util;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/8 1:35 PM
 **/
public class NullUtil {

  public static void main(String[] args) {
    if (null instanceof String) {
      System.out.println("null is object");
    } else {
      System.out.println("null is not object");
    }
  }
}
