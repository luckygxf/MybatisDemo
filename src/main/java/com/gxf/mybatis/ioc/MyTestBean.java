package com.gxf.mybatis.ioc;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/7 5:51 PM
 **/
public class MyTestBean implements InitializingBean {
  private String testStr = "hello ioc";

  static {
    System.out.println("static block testStr: ");
  }

  @PostConstruct
  private void postConstructMethod(){
    System.out.println("PostConstructMethod : " + testStr);
  }

  public MyTestBean() {
    System.out.println("Default constructor: " + testStr);
  }

  public String getTestStr() {
    return testStr;
  }

  public void setTestStr(String testStr) {
    this.testStr = testStr;
  }

  public void afterPropertiesSet() throws Exception {
    System.out.println("afterPropertiesSet: " + testStr);
  }
}
