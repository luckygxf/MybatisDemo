package com.gxf.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/23 3:17 PM
 **/
public class Student {
  private static Logger logger = LoggerFactory.getLogger(Student.class);

  public Student() {

  }
  public void seats(String objectName)
  {
    logger.info("学生回到教室:{}", objectName);
  }
  public void sayhello()
  {
    System.out.println("向老师问好");
  }
  public void ask()
  {
    System.out.println("上课提问");
  }
  public void endclass()
  {
    System.out.println("下课了");
  }
}