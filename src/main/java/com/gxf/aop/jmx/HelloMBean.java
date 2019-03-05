package com.gxf.aop.jmx;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/2/18 10:44 AM
 **/
public interface HelloMBean {
  //-----------
  // operations
  //-----------

  public void sayHello();
  public int add(int x, int y);

  //-----------
  // attributes
  //-----------

  // a read-only attribute called Name of type String
  public String getName();

  // a read-write attribute called CacheSize of type int
  public int getCacheSize();
  public void setCacheSize(int size);
}