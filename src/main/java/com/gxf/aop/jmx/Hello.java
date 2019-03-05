package com.gxf.aop.jmx;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/2/18 10:45 AM
 **/
public class Hello implements HelloMBean {
  private final String name = "Reginald";
  private static final int DEFAULT_CACHE_SIZE = 200;
  private int cacheSize = DEFAULT_CACHE_SIZE;

  public void sayHello() {
    System.out.println("hello, world");
  }

  public int add(int x, int y) {
    return x + y;
  }

  public String getName() {
    return this.name;
  }

  public int getCacheSize() {
    return this.cacheSize;
  }

  public synchronized void setCacheSize(int size) {
    this.cacheSize = size;
    System.out.println("Cache size now " + this.cacheSize);
  }
}