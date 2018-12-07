package com.gxf.mybatis.aware;

import org.springframework.context.*;

public class PropertyGettedListener implements ApplicationListener {
  public void onApplicationEvent(ApplicationEvent event) {
    System.out.println("PropertyGettedListener : " + event.getSource().toString());
  }
}