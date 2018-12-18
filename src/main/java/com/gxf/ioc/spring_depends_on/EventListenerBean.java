package com.gxf.ioc.spring_depends_on;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/15 2:52 PM
 **/
public class EventListenerBean {

  private void initialize() {
    EventManager.getInstance().
        addListener(s -> System.out.println("event received in EventListenerBean : " + s));
  }
}