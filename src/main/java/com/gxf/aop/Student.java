package com.gxf.aop;

/**
 * @Author: <guanxianseng@163.com>
 * @Description:
 * @Date: Created in : 2018/12/23 3:17 PM
 **/
public class Student {

  public Student() {

  }
  public void seats()
  {
    System.out.println("学生回到教室");
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