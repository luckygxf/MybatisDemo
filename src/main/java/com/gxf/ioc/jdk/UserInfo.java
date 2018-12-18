package com.gxf.ioc.jdk;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 9:08 PM
 **/
public class UserInfo {

  private long userId;
  private String userName;
  private int age;
  private String emailAddress;

  public long getUserId() {
    return userId;
  }
  public void setUserId(long userId) {
    this.userId = userId;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getEmailAddress() {
    return emailAddress;
  }
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }


  @Override
  public String toString() {
    return "UserInfo{" +
        "userId=" + userId +
        ", userName='" + userName + '\'' +
        ", age=" + age +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}