package com.gxf.aop.cglib.demo1;

import org.springframework.cglib.proxy.Dispatcher;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/26 11:22 PM
 **/

public class ConcreteClassDispatcher implements Dispatcher {

  @Override
  public Object loadObject() throws Exception {
    System.out.println("before Dispatcher...");
    PropertyBean propertyBean = new PropertyBean();
    propertyBean.setKey("xxx");
    propertyBean.setValue(new TargetObject());
    System.out.println("after Dispatcher...");
    return propertyBean;
  }


}
