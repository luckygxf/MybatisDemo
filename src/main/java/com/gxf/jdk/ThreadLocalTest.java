package com.gxf.jdk;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/15 10:53 AM
 **/
public class ThreadLocalTest {

  public static void main(String[] args) {
    ThreadLocal threadLocal1 = new ThreadLocal();
    ThreadLocal threadLocal2 = new ThreadLocal();

    Thread t = new Thread(() -> {
      threadLocal1.set("1");
      threadLocal2.set("2");

      System.out.println(threadLocal1.get());
      System.out.println(threadLocal2.get());
    });

    t.start();
  }
}
