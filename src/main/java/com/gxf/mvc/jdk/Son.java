package com.gxf.mvc.jdk;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/18 2:39 PM
 **/
public class Son extends Father {

  public static void main(String[] args) {
    Class father = Father.class;
    Class son = Son.class;
    System.out.println(father.isAssignableFrom(son));
  }
}
