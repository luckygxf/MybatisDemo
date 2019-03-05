package com.gxf.gxf_cache;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2019/3/5 11:27 AM
 **/
public class Main {

  public static void main(String[] args) throws InterruptedException {
    GxfCache gxfCache = new GxfCache();
    gxfCache.set("name", "guanxiangfei");
    gxfCache.setExpireTime("name", 3);
    System.out.println("gxfCache.get(\"name\"): " + gxfCache.get("name"));
    Thread.sleep(6000);
    System.out.println("gxfCache.get(\"name\"): " + gxfCache.get("name"));
  }
}
