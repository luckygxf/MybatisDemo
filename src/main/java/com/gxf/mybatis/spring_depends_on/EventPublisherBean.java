package com.gxf.mybatis.spring_depends_on;


public class EventPublisherBean {

  public void initialize() {
    System.out.println("EventPublisherBean initializing");
    EventManager.getInstance().publish("event published from EventPublisherBean");
  }
}
