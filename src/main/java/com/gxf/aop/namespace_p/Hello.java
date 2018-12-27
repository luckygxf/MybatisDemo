package com.gxf.aop.namespace_p;

import com.alibaba.fastjson.JSON;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/27 11:29 AM
 **/
public class Hello {
  private String p1;
  private String p2;
  private World world;

  public Hello() {
  }

  public Hello(String p1, String p2, World world) {
    this.p1 = p1;
    this.p2 = p2;
    this.world = world;
  }

  public String getP1() {
    return p1;
  }

  public void setP1(String p1) {
    this.p1 = p1;
  }

  public String getP2() {
    return p2;
  }

  public void setP2(String p2) {
    this.p2 = p2;
  }

  public World getWorld() {
    return world;
  }

  public void setWorld(World world) {
    this.world = world;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }
}
