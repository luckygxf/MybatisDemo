package com.gxf.mybatis.ioc_annotation;

import org.springframework.stereotype.Component;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/14 9:01 PM
 **/
public class TestBean {
  private String username;
  private String password;
  private String url;

  public TestBean(String username) {
    this.username = username;
    password = "pwd";
    url = "www.spring.com";
  }

  public TestBean() {
    username = "guanxianseng";
    password = "pwd";
    url = "www.spring.com";
  }

  public void sayHello(){
    System.out.println("TestBean sayHello...");
  }

  public String toString(){
    return "username:"+this.username+",url:"+this.url+",password:"+this.password;
  }

  public void start(){
    System.out.println("TestBean 初始化。。。");
  }

  public void cleanUp(){
    System.out.println("TestBean 销毁。。。");
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}