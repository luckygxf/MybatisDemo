package com.gxf.mvc.jdk;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/20 11:50 PM
 **/
import java.lang.*;

public class ClassDemo {

  public static void main(String[] args) {

    ClassDemo c = new ClassDemo();
    Class cls = c.getClass();

    // returns true if this class is a synthetic class, else false
    boolean retval = cls.isSynthetic();
    System.out.println("It is a synthetic class ? " + retval);
  }
}