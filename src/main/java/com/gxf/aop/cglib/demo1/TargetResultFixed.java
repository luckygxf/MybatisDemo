package com.gxf.aop.cglib.demo1;

import org.springframework.cglib.proxy.FixedValue;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description: 表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
 * @Date: Created in : 2018/12/26 9:08 PM
 **/
public class TargetResultFixed implements FixedValue {

  /**
   * 该类实现FixedValue接口，同时锁定回调值为999
   * (整型，CallbackFilter中定义的使用FixedValue型回调的方法为getConcreteMethodFixedValue，该方法返回值为整型)。
   */
  @Override
  public Object loadObject() throws Exception {
    System.out.println("锁定结果");
    Object obj = 999;
    return obj;
  }

}
