package com.gxf.mybatis.aware;


import org.springframework.context.*;

public class PropertyGettedEvent extends ApplicationEvent {
  public PropertyGettedEvent(Object source) {
    super(source);
  }
}