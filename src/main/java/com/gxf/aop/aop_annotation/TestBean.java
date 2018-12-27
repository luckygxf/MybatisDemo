package com.gxf.aop.aop_annotation;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/27 8:37 AM
 **/
public class TestBean {
  private String testStr = "testStr";

  public void test(){
    System.out.println("do business");
  }

  public String getTestStr() {
    return testStr;
  }

  public void setTestStr(String testStr) {
    this.testStr = testStr;
  }
}
