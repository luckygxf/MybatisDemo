package com.gxf.ioc.parent_beans;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 11:01 AM
 **/
public class HelloWorld {
  private String message1;
  private String message2;
  public void setMessage1(String message){
    this.message1  = message;
  }
  public void setMessage2(String message){
    this.message2  = message;
  }
  public void getMessage1(){
    System.out.println("World Message1 : " + message1);
  }
  public void getMessage2(){
    System.out.println("World Message2 : " + message2);
  }
}