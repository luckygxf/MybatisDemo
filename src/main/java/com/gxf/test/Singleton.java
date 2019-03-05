package com.gxf.test;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/1/11 11:29 AM
 **/
public class Singleton {
  private static volatile Singleton instance = new Singleton();
  public static Singleton getInstance1(){
    return instance;
  }

  public static synchronized Singleton getInstance2(){
    if(instance == null){
      instance = new Singleton();
    }
    return instance;
  }

  static class SingletonHolder {
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
      return instance;
    }
  }

  public static Singleton getInstance3(){
    if(instance == null){
      synchronized (Singleton.class){
        if(instance == null){
          instance = new Singleton();
        }
      }
    }
    return instance;
  }

}
