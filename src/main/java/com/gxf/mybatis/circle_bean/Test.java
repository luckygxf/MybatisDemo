package com.gxf.mybatis.circle_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/12/10 11:12 PM
 **/
public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("cicle_beans.xml");

  }
}
