package com.gxf.mybatis.jdk;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/10 9:10 PM
 **/
public class BeanInfoTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    UserInfo userInfo=new UserInfo();
    userInfo.setUserName("gxf");
    try {
      System.out.println("userInfo:" + userInfo);
      BeanInfoUtil.setProperty(userInfo, "emailAddress");
      System.out.println("userInfo:" + userInfo);
      BeanInfoUtil.getProperty(userInfo, "emailAddress");

      BeanInfoUtil.setProperty(userInfo, "userName");

      BeanInfoUtil.getProperty(userInfo, "userName");

      BeanInfoUtil.setPropertyByIntrospector(userInfo, "userName");

      BeanInfoUtil.getPropertyByIntrospector(userInfo, "userName");

//      BeanInfoUtil.setProperty(userInfo, "age");

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}